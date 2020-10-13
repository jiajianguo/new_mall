document.addEventListener("DOMContentLoaded", function() {

	let ICONJs = document.createElement("script");
	ICONJs.setAttribute("src", "https://at.alicdn.com/t/font_2092067_gw35bbtvujf.js");
	document.getElementsByTagName("head")[0].appendChild(ICONJs);


	let NavEle = document.getElementsByClassName("Nav")[0];
	NavEle ? NavEle.innerHTML =
		`<div class="ui-nav">
			<a class="item" href="/wap/index.htm">
				<svg class="icon" aria-hidden="true">
					<use xlink:href="#icon-dianpu"></use>
				</svg>
				<span class="item-text">首页</span>
			</a>
			<a class="item" href="/goodsclass.htm">
				<svg class="icon" aria-hidden="true">
					<use xlink:href="#icon-classify-on"></use>
				</svg>
				<span class="item-text">分类</span>
			</a>
			<a class="item" href="/goods_cart1.htm">
				<svg class="icon" aria-hidden="true">
					<use xlink:href="#icon-gouwuche-zhuangtai"></use>
				</svg>
				<span class="item-text">购物车</span>
			</a>
			<a class="item" href="/member_center.htm">
				<svg class="icon" aria-hidden="true">
					<use xlink:href="#icon-icon_mine"></use>
				</svg>
				<span class="item-text">我的</span>
			</a>
		</div>` : "";


	if(document.getElementsByClassName("header-button")[0]){
		document.getElementsByClassName("header-button")[0].addEventListener("click", function(event) {
			event.preventDefault();
			console.log(this);
			this.getAttribute("href") ? window.location.href = this.getAttribute("href") : window.history.go(-1)
		})
	}

	if(document.querySelector(".icon_left")){
		document.querySelector(".icon_left").addEventListener("click", function(event) {
			event.preventDefault();
			console.log(this);
			this.getAttribute("href") ? window.location.href = this.getAttribute("href") : window.history.go(-1)
		})
	}



	if(document.getElementsByClassName("ui-nav")[0]){

		let navList = [];
		let newindex = window.sessionStorage.getItem("newindex") || 0;

		document.getElementsByClassName("ui-nav")[0].childNodes.forEach(function(item) {
			if (item.nodeName === "A") {
				navList.push(item);
			}
		})

		navList[newindex].classList.add("active");
		navList.forEach((item, index) => {
			item.addEventListener("click", () => {
				window.sessionStorage.setItem("newindex", index);
			})
		})

	}





})
