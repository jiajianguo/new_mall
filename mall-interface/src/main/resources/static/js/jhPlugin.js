"use strict";
window.SAIL_ENV = {
    PAYPAL_ENV: "production",
    PAYPAL_CLIENT: {production: "prod"},
    API_HOST: "https://api.shksgyk.com",
    STATIC_HOST: "https://static.xshoppy.shop",
    CART_DEFAULT_IMAGES: "https://static.xshoppy.shop/theme/faker/pic-4.png"
}, $(function () {
    window.SAIL_ENV.config = {
        host: location.host,
        href: location.href,
        cartType: "1",
        cartToken: "",
        copyCouponCode: "",
        coupon_code: "",
        location: "",
        show_buycart: !1,
        currencyList: null,
        currencyEntity: {
            currency_code: $(".J-currency-code").val(),
            symbol: $(".J-currency-code").data("symbol"),
            rate_value: $(".J-currency-code").data("rate-value"),
            currency_text: ""
        },
        headcode: $(".J-currency-code").val(),
        headsymbol: $(".J-currency-code").data("symbol"),
        headRateValue: $(".J-currency-code").data("rate-value"),
        headCurrencyText: "",
        navigator: navigator.userAgent.toLowerCase(),
        isMobile: /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent),
        scrollPosition: 0,
        holidayStyle: "default",
        EmailReg: "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",
        availWidth: 0,
        index: {},
        products: {},
        collections: {},
        cart: {},
        orders: {},
        coupon_tips: function (e, a) {
            var t = "";
            switch (e += "") {
                case"1":
                    t = '<p class="erro-tips">This code did not match any active gift card or discount. Was it entered correctly?</p>';
                    break;
                case"2":
                case"3":
                    t = '<p class="erro-tips">Your cart does not meet the requirements for the <strong>' + a + "</strong> discount code</p>"
            }
            return t
        },
        mask_layer: function (e) {
            "hide" == e ? ($(".J-Mask").hide(), $("html, body").removeClass("hidden").css("top", ""), $("html, body").animate({scrollTop: SAIL_ENV.config.scrollPosition}, 0)) : "show" == e && ($(".J-Mask").show(), SAIL_ENV.config.scrollPosition = $(window).scrollTop(), $("html, body").addClass("hidden").css("top", "-" + SAIL_ENV.config.scrollPosition + "px"))
        }
    }, 900 <= window.screen.availWidth ? SAIL_ENV.config.availWidth = 1080 : window.screen.availWidth < 900 <= 750 ? SAIL_ENV.config.availWidth = 900 : SAIL_ENV.config.availWidth = 750
}), $(function () {
    var win_navigator = navigator.userAgent.toLowerCase();
    window.$plug = {
        loading: function (e) {
            var a = {title: "load", test: "姝ｅ湪鍔犺浇..."}, t = "", n = "string" == typeof e ? e : e ? this.merge(a, e) : a;
            0 < $(".J-MaskLoad").length ? $(".J-Loading").text(n.test) : (t += '<div class="nav-model-mask J-MaskLoad"><span class="nav-model-mask-close iconfont icon-close J-MaskLoadClose"></span></div>', t += '<div class="jh-loading J-Loading"><div class="load-icon"><img class="load-rotate" src="http://hn-img-mall-1.oss-cn-shenzhen.aliyuncs.com/buyer/public/img/load.png" /></div><div class="load-test">' + ("string" == typeof e ? n : n.test) + "</div></div>"), $("body").append(t), $(".J-MaskLoad, .J-Loading").show()
        }, load: function (e) {
            $(e).length && $(e).append('<div class="ajax-loading J-AjaxLoad"><em class="load iconfont icon-jiazai"></em></div>')
        }, closeLoad: function (e) {
            $(e).find(".J-AjaxLoad").length && $(e).find(".J-AjaxLoad").remove()
        }, closeLoading: function (e) {
            $(".J-MaskLoad, .J-Loading").hide(), e && $(".J-MaskLoad").removeClass("payment-model-mask").remove("span")
        }, alert: function () {
        }, modal: function () {
        }, testModal: function (e, a) {
            var t = a ? '<div class="jh-test-modal-mask J-TestModalMask"></div>' : '<div class="jh-test-modal-mask gray J-TestModalMask"></div>';
            t += '  <div class="jh-test-modal J-TestModal"><span class="iconfont icon-close J-TestModalClose"></span>', "string" == typeof e || "number" == typeof e ? t += "<p>You can only add " + e + " to the cart. </p>" : 0 < e.length && e.map(function (e) {
                t += "<p>" + e + " </p>"
            }), t += "</div>", $("body").append(t)
        }, tooltip: function () {
        }, merge: function (e, a) {
            for (var t in a) e[t] = a[t];
            return e
        }, message: {
            timeS: null, timeR: null, success: function (e) {
                this.init('<div class="jh-message-item msg-success J-MsgItem"><span class="iconfont icon-chenggong"></span><span>' + e + "</span></div>")
            }, info: function (e) {
                this.init('<div class="jh-message-item msg-info J-MsgItem"><span class="iconfont icon-tishi_icon"></span><span>' + e + "</span></div>")
            }, warning: function (e) {
                this.init('<div class="jh-message-item msg-warning J-MsgItem"><span class="iconfont icon-icon"></span><span>' + e + "</span></div>")
            }, error: function (e) {
                this.init('<div class="jh-message-item msg-error J-MsgItem"><span class="iconfont icon-shibai"></span><span>' + e + "</span></div>")
            }, init: function (e) {
                clearTimeout(this.timeS), clearTimeout(this.timeR), $(".J-Msg").length ? ($(".J-Msg").empty(), $(".J-Msg").append(e)) : (e = '<div class="jh-message J-Msg">' + e + "</div>", $("body").append(e)), this.timeS = setTimeout(function () {
                    $(".J-MsgItem").addClass("show")
                }, 300), this.timeR = setTimeout(function () {
                    $(".J-MsgItem").removeClass("show")
                }, 3e3)
            }
        }, lazyLoad: function (e) {
            var i, r = "",
                c = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i) ? "WAP" : "PC";
            "WAP" == c && (r = "?x-oss-process=image/resize,w_640"), i = $(document).scrollTop() ? parseInt($(document).scrollTop()) + parseInt($(window).height()) + 10 : parseInt($("html, body").scrollTop()) + parseInt($(window).height()) + 10, e.map(function (e, a) {
                var t = $(a).offset().top, n = a.tagName;
                if (t < i && $(a).hasClass("lazy-load")) if ("IMG" == n) $(a).attr("src", $(a).data("original")), $(a).addClass("blur-img").removeClass("lazy-load"); else {
                    var s = "";
                    $(a).parents(".banner") && $(a).parents(".banner").hasClass("swiper-container") ? "WAP" == c && 0 < $(".template4-body").length && (s = "?x-oss-process=image/crop,w_640,g_center") : s = r;
                    var o = new Image;
                    o.src = $(a).data("original") + s, o.onload = function () {
                        $(a).attr("style", "background-image: url('" + $(a).data("original") + s + "');background-size: cover"), $(a).addClass("blur-img").removeClass("lazy-load")
                    }
                }
            })
        },
        goTop: function () {
            $(document).on("click", ".J-GoTop", function () {
                $("html, body").animate({scrollTop: "0"}, 300)
            })
        },
        query: function () {
            var t = new Object;
            window.location.search && window.location.search.substr(1).split("&").forEach(function (e, a) {
                t[e.split("=")[0]] = e.split("=")[1]
            });
            return t
        },
        Pages: function (e, a, t) {
            if (0 == t.length || t.length <= e) return $(".J-Pages").empty(), !1;
            var n = "", s = parseInt(t / e), o = !1;
            s = t % e == 0 ? s : s + 1, 1 == a ? $(".J-PagesPrev").hide() : $(".J-PagesPrev").show(), a == s ? $(".J-PagesLast").hide() : $(".J-PagesLast").show();
            for (var i = 1; i <= s; i++) i <= a && 1 != a && (5 <= a ? (2 == i && (n += '<span class="pages-item J-PagesItem" data-index="">...</span>'), i == a && !o && (n += '<span class="pages-item J-PagesItem pages-item-active" data-index="' + i + '">' + i + "</span>", o = !0), (1 == i || i == a - 2 || i == a - 1) && (n += '<span class="pages-item J-PagesItem" data-index="' + i + '">' + i + "</span>")) : (i == a && !o && (n += '<span class="pages-item J-PagesItem pages-item-active" data-index="' + i + '">' + i + "</span>", o = !0), i != a && (n += '<span class="pages-item J-PagesItem" data-index="' + i + '">' + i + "</span>"))), a <= i && (4 <= s - a ? (i == a && !o && (n += '<span class="pages-item J-PagesItem pages-item-active" data-index="' + i + '">' + i + "</span>", o = !0), (i == a + 1 || i == a + 2 || i == s) && (n += '<span class="pages-item J-PagesItem" data-index="' + i + '">' + i + "</span>"), i == a + 3 && (n += '<span class="pages-item J-PagesItem" data-index="">...</span>')) : (i == a && !o && (n += '<span class="pages-item J-PagesItem pages-item-active" data-index="' + i + '">' + i + "</span>", o = !0), i != a && (n += '<span class="pages-item J-PagesItem" data-index="' + i + '">' + i + "</span>")));
            $(".J-PagesList").empty().append(n)
        }, isSame: function (e) {
            var a = !0, t = -1;
            0 < e.length && e.replace(/[^0-9]/gi, "").split("").map(function (e) {
                t < 0 ? t = e : t != e && (a = !1)
            });
            return a
        }, toRawType: function (e) {
            return Object.prototype.toString.call(e).slice(8, -1)
        }, getToKen: function (e) {
            var a = window.location.href.split("checkouts/")[1];
            return a = -1 < a.indexOf("?") ? a.split("?")[0] : a
        }, replaceParam: function replaceParam(url, arg, arg_val) {
            var href = "", pattern = arg + "=([^&]*)", replaceText = arg + "=" + arg_val;
            if (url.match(pattern)) {
                var tmp = "/(" + arg + "=)([^&]*)/gi";
                tmp = url.replace(eval(tmp), replaceText), window.history.replaceState({}, 0, tmp)
            } else href = url.match("[?]") ? url + "&" + replaceText : url + "?" + replaceText, window.history.replaceState({}, 0, href)
        }
    }, window.$http = {
        host: "",
        urlList: ["/payment/ipaylinks/pay", "/buyer/paypal/create-payment", "/buyer/express/match", "/sail/region/get-reached-countries"],
        getForm: function (e, a, t) {
            this.ajax(e, "GET", a, "html", t)
        },
        post: function (e, a, t) {
            this.ajax(e, "POST", a, "json", t)
        },
        get: function (e, a, t) {
            this.ajax(e, "GET", a, "json", t)
        },
        ajax: function (a, e, t, n, s) {
            var o = this;
            $.ajax({
                url: o.host + a,
                type: e,
                data: t,
                dataType: n,
                withCredentials: !0,
                contentType: "application/json",
                success: function (e) {
                    0 < $(".J-Loading").length && ($(".J-MaskLoad, .J-Loading").hide(), $("html, body").removeClass("hidden")), s && s(e), e.code
                },
                error: function (e) {
                    0 < $(".J-Loading").length && ($(".J-MaskLoad, .J-Loading").hide(), $("html, body").removeClass("hidden")), -1 < o.urlList.indexOf(a) && $plug.message.error("Sorry, can't be processed right now because of a technical issue. please try again later.")
                }
            })
        },
        upload: function (e, a) {
            var t = e.size / 1024 / 1024, n = new FormData;
            if (n.append("file", e), 10 < t) return $plug.message.error(SAIL_ENV.language[SAIL_ENV.language.lang].image_erro), !1;
            $.ajax({
                url: "/comm/upload/file",
                type: "POST",
                dataType: "json",
                timeout: 6e4,
                cache: !1,
                data: n,
                processData: !1,
                contentType: !1,
                success: function (e) {
                    0 == e.code ? a && a(e) : $plug.message.error(e.msg)
                },
                error: function (e) {
                    $plug.message.error(JSON.stringify(e))
                }
            })
        }
    }, window.stag = function (e, a, t, n) {
        var s = {
            event_type: e,
            event_name: a,
            params: {
                type: "check",
                additional: "",
                button_pos: "",
                user_agent: win_navigator,
                button_name: "",
                client_time: (new Date).getTime(),
                referer: $(".sail-event-referer").val() || "",
                page_name: $(".sail-event-page-location").val() || ""
            }
        };
        /* $.extend(s.params, t), n ? $http.post("/buyer/statistics/logger", JSON.stringify(s), function (e) {
             n(e)
         }) : $http.post("/buyer/statistics/logger", JSON.stringify(s))*/
    }, window.sharetag = function (e, a) {
        var t = {event_name: e, params: {source: a || ""}};
        $http.post("/buyer/logger/share", JSON.stringify(t))
    }
}), function (s, r) {
    s.lazyLoad = function (e) {
        var a;

        function c(e) {
            var a = null;
            if (e.dataset) a = e.dataset; else {
                for (var t, n = e.attributes, s = {}, o = 0; o < n.length; o++) (t = n[o].name.match(/^data-(.+)/)) && (s[t[1].replace(/-([\da-z])/gi, function (e, a) {
                    return a.toUpperCase()
                })] = n[o].value);
                a = s
            }
            if (!a.hasOwnProperty("widths")) return function () {
                try {
                    return 0 === r.createElement("canvas").toDataURL("image/webp", .5).indexOf("data:image/webp")
                } catch (e) {
                    return !1
                }
            }() ? a.original + "?x-oss-process=image/interlace,1/format,webp" : a.original;
            if (a.hasOwnProperty("widths")) {
                var i = {widths: JSON.parse(a.widths), original: a.original.split(",")};
                return i.widths.length <= 0 ? i.original[0] : -1 < i.widths.indexOf(SAIL_ENV.config.availWidth) ? i.original[i.widths.indexOf(SAIL_ENV.config.availWidth)] : i.original[i.original.length - 1]
            }
        }

        function t(o) {
            for (var i = s.screen.height, r = 0; r < o.length; r++) !function () {
                var e = o[r], a = c(e);
                if (a && !(-1 < e.className.indexOf("lazy-load-show"))) {
                    var t = e.getBoundingClientRect(), n = t.top + t.height + i;
                    if (t.top <= i && 0 < n) {
                        var s = new Image;
                        s.src = a, s.onload = function () {
                            e.className += " lazy-load-show", "IMG" == e.tagName && (e.src = a), "DIV" == e.tagName && (e.style.backgroundImage = "url(" + a + ")")
                        }
                    }
                }
            }()
        }

        "window" in (a = self) && "document" in a && "TextRectangle" in a && !("width" in a.TextRectangle.prototype) && Object.defineProperties(a.TextRectangle.prototype, {
            width: {
                get: function () {
                    return this.right - this.left
                }
            }, height: {
                get: function () {
                    return this.bottom - this.top
                }
            }
        });
        var n = e ? r.getElementsByClassName(e) : r.getElementsByTagName("img");
        "undefined" != typeof IntersectionObserver ? function (e) {
            for (var a = {
                root: null,
                rootMargin: "0px",
                threshold: [0]
            }, t = 0; t < e.length; t++) new IntersectionObserver(function (e, s) {
                e.forEach(function (e) {
                    if (e.isIntersecting) {
                        var a = new Image, t = e.target, n = c(t);
                        if (!n || -1 < t.className.indexOf("lazy-load-show")) return !1;
                        a.src = n, a.onload = function () {
                            t.classList.add("lazy-load-show"), "IMG" == t.tagName && (t.src = n), "DIV" == t.tagName && (t.style.backgroundImage = "url(" + n + ")"), s.disconnect()
                        }
                    }
                })
            }, a).observe(e[t])
        }(n) : (t(n), s.onscroll = function () {
            t(n)
        })
    }
}(window, document), lazyLoad("J-LazyLoad"), window.onload = function () {
    lazyLoad("J-LazyLoad")
};
