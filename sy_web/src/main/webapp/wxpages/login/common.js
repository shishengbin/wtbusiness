function GetQueryString(e){var t=new RegExp("(^|&)"+e+"=([^&]*)(&|$)"),o=window.location.search.substr(1).match(t);return null!=o?unescape(o[2]):null}function addcookie(e,t,o){var n=e+"="+escape(t)+"; path=/";if(o>0){var i=new Date;i.setTime(i.getTime+3600*o*1e3),n=n+"; expire="+i.toGMTString()}document.cookie=n}function getcookie(e){for(var t=document.cookie,o=t.split("; "),n=0;n<o.length;n++){var i=o[n].split("=");if(i[0]==e)return i[1]}return""}function delCookie(e){var t=new Date;t.setTime(t.getTime()-1);var o=getcookie(e);null!=o&&(document.cookie=e+"="+o+"; path=/;expires="+t.toGMTString())}function checklogin(e){return 0==e?(location.href=WapSiteUrl+"/tmpl/member/login.html",!1):!0}function contains(e,t){for(var o=e.length;o--;)if(e[o]===t)return!0;return!1}function buildUrl(e,t){switch(e){case"keyword":return WapSiteUrl+"/tmpl/product_list.html?keyword="+encodeURIComponent(t);case"special":return WapSiteUrl+"/special.html?special_id="+t;case"goods":return WapSiteUrl+"/tmpl/product_detail.html?goods_id="+t;case"url":return t;case"":return t;case"undefined":return t}return WapSiteUrl}function request(e){var t=location.href;t=decodeURI(t);for(var o=t.substring(t.indexOf("?")+1,t.length).split("&"),n={},i=0;j=o[i];i++)n[j.substring(0,j.indexOf("=")).toLowerCase()]=j.substring(j.indexOf("=")+1,j.length);var r=n[e.toLowerCase()];return"undefined"==typeof r?"":r}function optimizeFun(){this.lazyLoad=function(e,t){!function(e,t){"function"==typeof define&&define.amd?define(function(){return t(e)}):"object"==typeof exports?module.exports=t:e.echo=t(e)}(that,function(e){"use strict";var t,o,n,i,r,c={},a=function(){},l=function(e){return null===e.offsetParent},u=function(e,t){if(l(e))return!1;var o=e.getBoundingClientRect();return o.right>=t.l&&o.bottom>=t.t&&o.left<=t.r&&o.top<=t.b},s=function(){(i||!o)&&(clearTimeout(o),o=setTimeout(function(){c.render(),o=null},n))};return c.init=function(o){o=o||{};var l=o.offset||0,u=o.offsetVertical||l,d=o.offsetHorizontal||l,f=function(e,t){return parseInt(e||t,10)};t={t:f(o.offsetTop,u),b:f(o.offsetBottom,u),l:f(o.offsetLeft,d),r:f(o.offsetRight,d)},n=f(o.throttle,250),i=o.debounce!==!1,r=!!o.unload,a=o.callback||a,c.render(),document.addEventListener?(e.addEventListener("scroll",s,!1),e.addEventListener("load",s,!1)):(e.attachEvent("onscroll",s),e.attachEvent("onload",s))},c.render=function(){for(var o,n,i=document.querySelectorAll("img[data-echo], [data-echo-background]"),l=i.length,s={l:0-t.l,t:0-t.t,b:(e.innerHeight||document.documentElement.clientHeight)+t.b,r:(e.innerWidth||document.documentElement.clientWidth)+t.r},d=0;l>d;d++)n=i[d],u(n,s)?(r&&n.setAttribute("data-echo-placeholder",n.src),null!==n.getAttribute("data-echo-background")?n.style.backgroundImage="url("+n.getAttribute("data-echo-background")+")":n.src=n.getAttribute("data-echo"),r||(n.removeAttribute("data-echo"),n.removeAttribute("data-echo-background")),a(n,"load")):r&&(o=n.getAttribute("data-echo-placeholder"))&&(null!==n.getAttribute("data-echo-background")?n.style.backgroundImage="url("+o+")":n.src=o,n.removeAttribute("data-echo-placeholder"),a(n,"unload"));l||c.detach()},c.detach=function(){document.removeEventListener?e.removeEventListener("scroll",s,!1):e.detachEvent("onscroll",s),clearTimeout(o)},c})},this.lazyLoadSelf=function(e){function t(){bottom=document.body.scrollTop+n,o()}function o(){for(var o=0;o<e.length;o++)$(e[o]).offset().top<=bottom&&(e[o].src=e[o].getAttribute("data-src"),e[o].setAttribute("haveLoaded","1"),e.splice(o,1),o--);0==e.length&&document.querySelector("body").removeEventListener("touchmove",t,!1)}var n=document.documentElement.clientHeight;bottom=document.body.scrollTop+n,o(),document.querySelector("body").addEventListener("touchmove",t,!1)},this.autoChange=function(e,t){var o=document.documentElement.clientWidth,n=t/(1*e/o);n=n>100?100:n,document.querySelector("html").style.fontSize=n+"px",AGG.font_size=n}}function Win(){}if("undefined"==typeof AGG)var AGG={};AGG.isWeixin=function(){var e=navigator.userAgent.toLowerCase();if("micromessenger"!=e.match(/MicroMessenger/i)){var t=['<div id="MustWeichat" style="display: none;position:absolute;top:0;left: 0; width: 100%;height:100%; z-index: 1000000;text-align: center;background:#fff;">','<div style="display:inline-block;width:60%;margin-top:25%;text-align: center;"><img src="images/pretty_girl.png" style="width:100%;"></div>','<div style="display:inline-block;width:80%;margin-top:10px;text-align: center;">对不起，此页面无法用浏览器打开，请返回微信页面。<br/>','<br/>您可以添加微信公众号<span style="color:red;">aigegou51</span>进入商城首页</div></div>'].join("");return $("body").html(t),$("#MustWeichat").show(),!1}return!0},AGG.client={type:function(){var e=request("client_type").toLowerCase()||getcookie("client_type").toLowerCase();return""==getcookie("client_type")&&addcookie("client_type",e),e},isApp:function(){return"ios"==this.type()||"android"==this.type()?!0:!1}},AGG.optimize=new optimizeFun;var that=this;AGG.optimize.lazyLoad(),Win.prototype={newalert:function(e,t){$(".alertBox").remove();var o=$('<div class="alertBox"></div>');o.appendTo("body"),o.html("<span>"+e+"</span>").show().css("bottom","60px"),setTimeout(function(){o.css("opacity","0")},2e3),setTimeout(function(){o.remove(),"function"==typeof t&&t()},2500)},newalert2:function(e,t){$(".alertBox2").remove();var o=$('<div class="alertBox2"></div>');o.appendTo("body"),o.html('<div class="alertContent"><span>'+e+"</span></div>").show().css("opacity","1"),setTimeout(function(){o.css("opacity","0")},2e3),setTimeout(function(){o.remove(),"function"==typeof t&&t()},2200)},newconfirm:function(e,t,o,n){$("body").css("overflow","hidden");var i=$('<div class="confirmBox"></div>');i.appendTo("body");var r='<div class="confirm-con"><h4>'+e+"</h4><p>"+t+'</p><div class="confirmBtn"><a class="ackBtn">确定</a><a class="cancelBtn"><span>取消</span></a></div></div>';i.html(r),$(".ackBtn").on("click",function(){$("body").css("overflow","auto"),i.remove(),"function"==typeof o&&o()}),$(".cancelBtn").on("click",function(){$("body").css("overflow","auto"),i.remove(),"function"==typeof n&&n()})}};