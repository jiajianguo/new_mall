!function (e) {
    var a = {}, t = [{
        id: "generic-analytics", triggers: [], run: function (c, t) {
            try {
                var e = function () {
                    for (var e, t = document.getElementsByTagName("link"), n = {storeId: c.ecwidStoreID}, r = {storeId: (c.__st || {}).a}, o = {
                        shopPath: (c.config || {}).ShopPath,
                        storeId: void 0
                    }, i = {
                        metaSiteId: (c.rendererModel || {}).metaSiteId,
                        siteId: ((c.rendererModel || {}).siteInfo || {}).siteId
                    }, a = {storeId: (c.options || {}).accountId}, u = 0; u < t.length; u++) {
                        var s = t[u];
                        if (/\/(s-\w+)\//.test(s.href) && (o.storeId = (s.href.match(/\/(s-\w+)\//) || [])[1]), "canonical" === s.getAttribute("rel") && (e = s.href), o.storeId && e) break
                    }
                    return {partners: {ecwid: n, bigCommerce: o, shopify: r, wix: i, bigCartel: a}, canonicalUrl: e}
                }();
                n = e, t.track("pageView", {
                    fltp: "analytics-generic",
                    sub_component: "analytics",
                    subfeature1: "analytics",
                    context: t.get("pptm:context"),
                    feature: "generic",
                    pageType: "merchant"
                }, t.objectAssign({ru: n.canonicalUrl, sinfo: JSON.stringify({partners: n.partners})}))
            } catch (e) {
                t.log({t: "error", msg: "Generic analytics tracking failed", stack: e.stack})
            }
            var n
        }, configuration: {}
    }];
    !function i(a, u, s) {
        function c(t, e) {
            if (!u[t]) {
                if (!a[t]) {
                    var n = "function" == typeof require && require;
                    if (!e && n) return n(t, !0);
                    if (g) return g(t, !0);
                    var r = new Error("Cannot find module '" + t + "'");
                    throw r.code = "MODULE_NOT_FOUND", r
                }
                var o = u[t] = {exports: {}};
                a[t][0].call(o.exports, function (e) {
                    return c(a[t][1][e] || e)
                }, o, o.exports, i, a, u, s)
            }
            return u[t].exports
        }

        for (var g = "function" == typeof require && require, e = 0; e < s.length; e++) c(s[e]);
        return c
    }({
        1: [function (e, t, n) {
            function r(t) {
                return function () {
                    var e = void 0;
                    try {
                        e = t()
                    } catch (e) {
                        try {
                            o({msg: e && (e.msg || e.message), stack: e && e.stack})
                        } catch (e) {
                        }
                    }
                    return e
                }
            }

            function i(e) {
                var t = -1;
                return void 0 !== e && (t = e === parseInt(e, 10) ? e : 0 < e && e < 1 ? parseFloat(e.toFixed(1)) : parseFloat(e.toFixed(0))), t
            }

            var o = e("./log")(), a = r(function () {
                return document.title
            }), u = r(function () {
                return window.location.href
            }), s = r(function () {
                return window.screen.colorDepth
            }), c = r(function () {
                return window.screen.height
            }), g = r(function () {
                return window.screen.width
            }), l = r(function () {
                return "NA"
            }), f = r(function () {
                var e = window.screen || {}, t = window.devicePixelRatio || 1, n = i(e.width * t), r = i(e.height * t);
                if (90 === Math.abs(window.orientation)) {
                    var o = n;
                    n = r, r = o
                }
                return r
            }), p = r(function () {
                var e = window.screen || {}, t = window.devicePixelRatio || 1, n = i(e.width * t), r = i(e.height * t);
                if (90 === Math.abs(window.orientation)) {
                    var o = n;
                    n = r, r = o
                }
                return n
            }), d = r(function () {
                var e = window, t = "inner";
                return "innerWidth" in window || (t = "client", e = document.documentElement || document.body), e[t + "Height"]
            }), v = r(function () {
                var e = window, t = "inner";
                return "innerWidth" in window || (t = "client", e = document.documentElement || document.body), e[t + "Width"]
            }), w = function () {
                return {
                    director: "application/x-director",
                    mediaplayer: "application/x-mplayer2",
                    pdf: "application/pdf",
                    quicktime: "video/quicktime",
                    real: "audio/x-pn-realaudio-plugin",
                    silverlight: "application/x-silverlight"
                }
            }, h = function () {
                var e = null;
                if (window.navigator.plugins && 0 < window.navigator.plugins.length) {
                    var t = "application/x-shockwave-flash", n = window.navigator.mimeTypes;
                    n && n[t] && n[t].enabledPlugin && n[t].enabledPlugin.description && (e = n[t].enabledPlugin.description)
                }
                return e
            }, m = function (e) {
                var t = window.navigator.mimeTypes;
                if (t && t.length) {
                    var n = t[e];
                    return n && n.enabledPlugin
                }
            }, y = r(function () {
                var e = [], t = w();
                for (var n in t) m(t[n]) && e.push(n);
                var r = h();
                return r && e.push(r), e.join(",")
            }), b = r(function () {
                return window.navigator.languages ? window.navigator.languages.join ? window.navigator.languages.join(",") : window.navigator.languages : window.navigator.userLanguage ? window.navigator.userLanguage : window.navigator.language ? window.navigator.language : window.navigator.browserLanguage ? window.navigator.browserLanguage : window.navigator.systemLanguage ? window.navigator.systemLanguage : void 0
            });
            t.exports = {
                _getBrowserDataFactory: r,
                getPageTitle: a,
                getWindowLocation: u,
                getDeviceHeight: f,
                getDeviceWidth: p,
                getBrowserHeight: d,
                getBrowserWidth: v,
                getColorDepth: s,
                getScreenHeight: c,
                getScreenWidth: g,
                getJSVersion: l,
                getBrowserPlugins: y,
                getRosettaLanguage: b
            }
        }, {"./log": 4}], 2: [function (e, t, n) {
            var r = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (e) {
                return typeof e
            } : function (e) {
                return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
            }, o = "function" == typeof Symbol && "symbol" === r(Symbol.iterator) ? function (e) {
                return void 0 === e ? "undefined" : r(e)
            } : function (e) {
                return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : void 0 === e ? "undefined" : r(e)
            }, i = e("./pptm");
            "object" === (void 0 === a ? "undefined" : o(a)) && (a = i())
        }, {"./pptm": 6}], 3: [function (e, t, n) {
            t.exports = function (t) {
                return {
                    url: function () {
                        var e = t.location.href.split("#")[0];
                        return "/" === e[e.length - 1] ? e.substr(0, e.length - 1) : e
                    }, hostname: function () {
                        return t.location.hostname
                    }, path: function () {
                        var e = t.location.pathname;
                        return "" === e ? "/" : "/" === e[e.length - 1] ? e.substring(0, e.length - 1) : e
                    }
                }
            }
        }, {}], 4: [function (e, t, n) {
            var r = e("./request-beacon");
            t.exports = function (t) {
                return function (e) {
                    t = t || "https://www.paypal.com/tagmanager/log", "string" == typeof e && (e = {msg: e}), r.send(t, e)
                }
            }
        }, {"./request-beacon": 7}], 5: [function (e, t, n) {
            var r = {
                co: function (e, t) {
                    return !!~e.indexOf(t)
                }, nco: function (e, t) {
                    return !r.co(e, t)
                }, ew: function (e, t) {
                    return new RegExp(t + "$").test(e)
                }, new: function (e, t) {
                    return !r.ew(e, t)
                }, eq: function (e, t) {
                    return e === t
                }, neq: function (e, t) {
                    return !r.eq(e, t)
                }
            };
            t.exports = r
        }, {}], 6: [function (e, t, n) {
            function l(e, t) {
                switch (t) {
                    case"snippetRun":
                        return !e.snippetRun;
                    default:
                        return 1
                }
            }

            function f(e) {
                var t = e.paypalDDL, n = {event: "snippetRun", t: (new Date).getTime()};
                if (t) {
                    for (var r = !1, o = 0; o < t.length; ++o) "snippetRun" === t[o].event && (r = !0);
                    r || t.push(n)
                } else t = [n];
                return t
            }

            function r(g) {
                return function (e, t, n, r) {
                    if (void 0 !== e) {
                        g.variables = t || {}, g.tags = n || {}, g.triggers = r || {}, g.unprocessedEvents = [], g.finalDDL = {}, g.eventListeners = {}, g.snippetRun = !1;
                        var o, i, a, u = "$$page$view";
                        if (g.triggers[u] = {id: u, type: "snippetRun"}, function (e, t) {
                            for (var n in e) {
                                if (e.hasOwnProperty(n)) e[n].triggers && e[n].triggers.length || (e[n].triggers = [t])
                            }
                        }(g.tags, u), g.log = d(g.variables.logServer), g.on = b(e, g), g.builtinVars = v(e), g.shouldTagTrigger = w.createShouldTagTrigger(g.triggers, g.builtinVars), g.processEvents = (o = g, function (e) {
                            for (; o.unprocessedEvents.length;) {
                                var t = o.unprocessedEvents.shift();
                                if (o.finalDDL = p({}, o.finalDDL, t), t.event && l(o, t.event) && (w.isKnownTriggerEvent(t.event) ? o.triggerTags(t.event, t) : o.triggerTags("customEvent", t), e && o.eventListeners[t.event])) for (var n = 0; n < o.eventListeners[t.event].length; ++n) o.eventListeners[t.event][n](t)
                            }
                        }), g.triggerTags = (i = e, a = g, function (e, t) {
                            for (var n = 0; n < a.tags.length; ++n) {
                                var r = a.tags[n];
                                if (!h(r)) return void a.log({
                                    t: "error",
                                    msg: "Malformed tag has been prevented from running"
                                });
                                try {
                                    a.shouldTagTrigger(r, e, t) && r.run(i, S(i, a, r))
                                } catch (e) {
                                    a.log({t: "error", msg: e.message, stack: e.stack})
                                }
                            }
                        }), void 0 !== n) {
                            var s = e.paypalDDL = f(e), c = s.push;
                            s.push = function () {
                                for (var e, t = arguments.length, n = Array(t), r = 0; r < t; r++) n[r] = arguments[r];
                                return (e = g.unprocessedEvents).push.apply(e, n), g.processEvents(!0), c.apply(s, n)
                            }, g.unprocessedEvents.push.apply(g.unprocessedEvents, s.slice(0)), g.processEvents(), g.snippetRun = !0
                        } else g.log("`pptm.init` called with undefined `tags`")
                    }
                }
            }

            var o = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (e) {
                    return typeof e
                } : function (e) {
                    return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
                }, i = "function" == typeof Symbol && "symbol" === o(Symbol.iterator) ? function (e) {
                    return void 0 === e ? "undefined" : o(e)
                } : function (e) {
                    return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : void 0 === e ? "undefined" : o(e)
                }, p = Object.assign || function (e) {
                    for (var t = 1; t < arguments.length; t++) {
                        var n = arguments[t];
                        for (var r in n) Object.prototype.hasOwnProperty.call(n, r) && (e[r] = n[r])
                    }
                    return e
                }, a = e("./track"), d = e("./log"), v = e("./builtin-variables"), w = e("./trigger-utils"),
                u = a.createTrack, s = a.getTrackingData, h = function (e) {
                    return "object" === (void 0 === e ? "undefined" : i(e)) && "string" == typeof e.id && "function" == typeof e.run && "object" === i(e.configuration)
                }, c = function (t, n) {
                    return function (e) {
                        return /^pptm:/.test(e) ? t[e.split(":")[1]] : n.configuration[e]
                    }
                }, g = function (e, t) {
                    return function () {
                        return t.configuration
                    }
                }, m = function (u) {
                    return function (e, t, n) {
                        var r, o, i = u.createElement("script");
                        i.type = "text/javascript", i.async = !0, i.src = e, r = i, "function" == typeof (o = t) && (r.addEventListener ? r.onload = o : r.onreadystatechange = function () {
                            /(loaded|complete)/.test(r.readyState) && (r.onreadystatechange = null, o())
                        }), "function" == typeof n && (i.onerror = n);
                        var a = u.getElementsByTagName("head")[0];
                        a && a.appendChild(i)
                    }
                }, y = Object.assign || function (e) {
                    for (var t = 1; t < arguments.length; t++) {
                        var n = arguments[t];
                        for (var r in n) Object.prototype.hasOwnProperty.call(n, r) && (e[r] = n[r])
                    }
                    return e
                }, b = function (o, i) {
                    return function (e, t) {
                        i.eventListeners[e] = i.eventListeners[e] || [], i.eventListeners[e].push(t);
                        for (var n = f(o), r = 0; r < n.length; ++r) n[r].event === e && t(n[r])
                    }
                }, S = function (e, t, n) {
                    var r = {get: c(t.variables, n), getAll: g(t.variables, n), insertExternalScript: m(e.document)};
                    return r.getTrackingData = s(t), r.track = u(r.get("pptm:fptiServer")), r.log = t.log, r.on = t.on, r.objectAssign = y, r
                };
            t.exports = function () {
                return {init: r({tags: {}, triggers: {}, variables: []})}
            }
        }, {"./builtin-variables": 3, "./log": 4, "./track": 8, "./trigger-utils": 9}], 7: [function (e, t, n) {
            t.exports = {
                send: function (e, t) {
                    if (e && t) {
                        var n = [];
                        for (var r in t) t.hasOwnProperty(r) && n.push(encodeURIComponent(r) + "=" + encodeURIComponent(t[r]));
                        n = n.join("&"), (new window.Image).src = e + "?" + n
                    }
                }
            }
        }, {}], 8: [function (e, t, n) {
            function a(e) {
                return s({
                    identifier: "tagmanagernodeweb",
                    website: "muse",
                    feature: "third-party",
                    s: "ci",
                    subfeature1: "",
                    subfeature2: "",
                    sub_component: "",
                    pageType: "",
                    userType: "",
                    flavor: "",
                    es: "",
                    testVariant: "",
                    link: "",
                    erpg: "",
                    context: {},
                    flag_consume: ""
                }, e)
            }

            function u(e, t) {
                return s({
                    pgrp: [e.website, e.feature, e.subfeature1, e.subfeature2, e.pageType].join(":"),
                    page: [e.website, e.feature, e.subfeature1, e.subfeature2, e.pageType, e.userType, e.flavor, e.testVariant].join(":"),
                    tsrce: e.identifier,
                    comp: e.identifier,
                    sub_component: e.sub_component,
                    s: e.s,
                    item: e.item,
                    fltp: e.fltp,
                    link: e.link,
                    es: e.flavor,
                    cust: e.cust,
                    mrid: e.mrid,
                    erpg: e.erpg,
                    error_code: e.error_code,
                    xe: e.xe,
                    xt: e.xt,
                    qe: e.qe,
                    qt: e.qt,
                    code: e.context.bn_code,
                    partner_name: e.context.partner_name,
                    flag_consume: e.flag_consume,
                    pt: e.pt || g.getPageTitle(),
                    dh: e.dh || g.getDeviceHeight(),
                    dw: e.dw || g.getDeviceWidth(),
                    bh: e.bh || g.getBrowserHeight(),
                    bw: e.bw || g.getBrowserWidth(),
                    cd: e.cd || g.getColorDepth(),
                    sh: e.sh || g.getScreenHeight(),
                    sw: e.sw || g.getScreenWidth(),
                    v: e.v || g.getJSVersion(),
                    pl: e.pl || g.getBrowserPlugins(),
                    rosetta_language: e.rosetta_language || g.getRosettaLanguage(),
                    correlation_id: e.correlation_id,
                    mru: e.mru,
                    unsc: e.unsc,
                    identifier_used: e.identifier_used,
                    offer_id: e.offer_id,
                    soid: e.soid
                }, t)
            }

            var s = Object.assign || function (e) {
                for (var t = 1; t < arguments.length; t++) {
                    var n = arguments[t];
                    for (var r in n) Object.prototype.hasOwnProperty.call(n, r) && (e[r] = n[r])
                }
                return e
            }, c = e("./request-beacon"), g = e("./analytics"), l = ["pageView", "click"];
            t.exports = {
                createTrack: function (i) {
                    return function (e) {
                        var t = 1 < arguments.length && void 0 !== arguments[1] ? arguments[1] : {},
                            n = 2 < arguments.length && void 0 !== arguments[2] ? arguments[2] : {};
                        if (i = i || "https://t.paypal.com/ts", !!~function (e) {
                            for (var t = 0; t < l.length; ++t) if (l[t] === e) return t;
                            return -1
                        }(e)) {
                            var r = u(a(t)), o = s({}, r, {e: "pageView" === e ? "im" : "cl"}, "click" === e ? {
                                pglk: r.pgrp + "|" + r.link,
                                pgln: r.page + "|" + r.link
                            } : {}, {
                                t: (new Date).getTime(),
                                g: (new Date).getTimezoneOffset(),
                                completeurl: g.getWindowLocation()
                            }, n);
                            c.send(i, function (e) {
                                var t = {};
                                for (var n in e) e.hasOwnProperty(n) && (!e[n] && !1 !== e[n] && 0 !== e[n] || (t[n] = e[n]));
                                return t
                            }(o))
                        }
                    }
                }, getTrackingData: function () {
                    return function () {
                        var e = 0 < arguments.length && void 0 !== arguments[0] ? arguments[0] : {};
                        return e = a(e), overrides = {completeurl: g.getWindowLocation()}, u(e, overrides)
                    }
                }
            }
        }, {"./analytics": 1, "./request-beacon": 7}], 9: [function (e, t, n) {
            function g(e, t, n, r) {
                if (!(r.type === t)) return !1;
                var o = r.filters || [];
                if (!!!o.length) return !0;
                for (var i = !0, a = 0; a < o.length; ++a) {
                    var u = o[a], s = void 0;
                    switch (u.type) {
                        case"BUILT_IN":
                            s = e[u.variable]();
                            break;
                        case"DDL":
                            s = n[u.variable]
                    }
                    i = i && c[u.operator](s, u.value)
                }
                return i
            }

            var c = e("./operators"), r = {snippetRun: !0};
            t.exports = {
                createShouldTagTrigger: function (s, c) {
                    return function (e, t, n) {
                        var r = e.triggers;
                        if (!(r && !!r.length)) return !0;
                        for (var o = !1, i = 0; i < r.length; ++i) {
                            var a = s[r[i]], u = g(c, t, n, a);
                            o = o || u
                        }
                        return o
                    }
                }, isKnownTriggerEvent: function (e) {
                    return !!r[e]
                }
            }
        }, {"./operators": 5}]
    }, {}, [2]), "object" == typeof a && a.init && a.init(e, {
        containerIndex: 1,
        containerId: null,
        merchantId: null,
        containerUrl: null,
        fptiServer: "https://t.paypal.com/ts",
        logServer: "https://www.paypal.com/tagmanager/log",
        env: "production",
        context: {mock: !0}
    }, t, {})
}(window);
