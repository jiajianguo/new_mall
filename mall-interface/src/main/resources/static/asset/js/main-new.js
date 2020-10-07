document.addEventListener("DOMContentLoaded", function() {

    let ICONJs = document.createElement("script");
    ICONJs.setAttribute("src", "https://at.alicdn.com/t/font_2092067_5e9g3o9d4q.js");
    document.getElementsByTagName("head")[0].appendChild(ICONJs);

    if(document.getElementsByClassName("header-button")[0]){
        document.getElementsByClassName("header-button")[0].addEventListener("click", function(event) {
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
