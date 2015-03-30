function showSubMenu(obj, menuId) {
		var ul = obj.parentNode.getElementsByTagName("ul")[0];
		if(ul != null && ul != undefined) {
			if (ul.style.display == "none" || ul.style.display == "" || ul.style.display.length == 0 ) {
				ul.style.display = "block";
				addToCookie(menuId, obj.parentNode.getElementsByTagName("ul")[0].id);
			} else { 
				ul.style.display = "none";
				removeFromCookie(menuId, obj.parentNode.getElementsByTagName("ul")[0].id);
			}
		}
}

function showMenu(menuId, strMenu) {
        document.getElementById(menuId).innerHTML = strMenu;
		verificaEstado(menuId);
} 

function verificaEstado(menuId){
	cookieValue = getCookie(menuId);
	if (cookieValue != ""){
		cookie = cookieValue.substring(1, cookieValue.length);
		var idsLi = cookie.split(".");
		for(var i = 0; i < idsLi.length; i++){
			li = document.getElementById(idsLi[i]);
			if (li != null && li != undefined) {
				ul = li.parentNode.getElementsByTagName("ul")[0];
				ul.style.display = "block";
			}
		}
	}
}

function setCookie(c_name,value,expiredays){
	var exdate=new Date()
	exdate.setDate(exdate.getDate()+expiredays)
	document.cookie=c_name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
}

function addToCookie(cookieName, id){
	var cookieValue = getCookie(cookieName);
	if (cookieValue.indexOf("."+id) == -1)
		cookieValue = cookieValue + "." + id;
	setCookie(cookieName, cookieValue, 1);
}

function removeFromCookie(cookieName, id){
	var cookieValue = getCookie(cookieName);
	cookieValue = cookieValue.replace("."+id, "");
	setCookie(cookieName, cookieValue, 1);
}

function getCookie(c_name){
	if (document.cookie.length>0){
  		c_start=document.cookie.indexOf(c_name + "=")
		if (c_start!=-1){ 
		    c_start=c_start + c_name.length+1 
    		c_end=document.cookie.indexOf(";",c_start)
    		if (c_end==-1) c_end=document.cookie.length
    			return unescape(document.cookie.substring(c_start,c_end))
		} 
	}
	return ""
}