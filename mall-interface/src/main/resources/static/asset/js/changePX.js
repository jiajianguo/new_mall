(function(docs, win) {
	htmlSize = function() {
		var value = document.documentElement.clientWidth
		var ua = navigator.userAgent
		var deviceWidth = Math.min(750, value)
		document.documentElement.style.fontSize = 100 * (deviceWidth / 750) + "px";
	};
	htmlSize();
	window.onresize = function(){
		htmlSize();
	}
})(document, window);





