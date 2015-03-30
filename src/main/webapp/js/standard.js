	function submitLov(url) {
 		$.ajax({
  	 	url: url,
	   	success: function(data) {
	   		$("#lovcontent").html($($.parseHTML(data)).find('#maincontent > *'));
   		},
   		complete: function() {
   		  $("#lovcontent input[type='submit']").unbind('click').click(function() {
			   	action = $(this).attr("name");
   				form = $(this).parents("form");
   		    newUrl = form.attr('action') + "?" + action + "=&" + form.serialize();
   				submitLov(newUrl);
   		    return false;
   		  });
      }
 		});
 	}
		
	function openLovDialog(url, height, width, modal, resizable, top, left) {
		submitLov(url);
		if (modal == null) {
			modal = true;
		}
		if (resizable) {
			resizable = false;
		}
		if (top != null) {
			if (!(top == "top" || top == "center" || top == "bottom")) {
				top = "top+" + top;
			}
		} else {
			top = "center";
		}
		if (left != null) {
			if (!(left == "left" || left == "center" || left == "right")) {
				left = "left+" + left;
			}
		} else {
			left = "center";
		}
		$( "#lovdialog" ).dialog({
			height: height,
      width: width,
			modal: modal,
			resizable: resizable,
			position: { my: "left top", at: left + " " + top, of: window }
		});
	}

	function registerFunction(functionBody) {
		"use strict";
		var script = document.createElement("script");
		script.innerHTML = "function " + functionBody;
		document.body.appendChild(script);
	}
	
	function refreshNavigator(posAction, navigator, pos, totalValue, ajax) {
		if (navigator != null && navigator.attr("id") != null) {
			var navigatorPos = $("#" + navigator.attr("id") + "Pos");
			var navigatorTotal = $("#" + navigator.attr("id") + "Total");
			var navigatorFirst = $("#" + navigator.attr("id") + "First");
			var navigatorPrev = $("#" + navigator.attr("id") + "Prev");
			var navigatorNext = $("#" + navigator.attr("id") + "Next");
			var navigatorLast = $("#" + navigator.attr("id") + "Last");
			navigatorFirst.click(function() { newNavigatorPos("first", posAction, navigator, pos, totalValue, ajax); });
			navigatorPrev.click(function() { newNavigatorPos("prev", posAction, navigator, pos, totalValue, ajax); });
			navigatorNext.click(function() { newNavigatorPos("next", posAction, navigator, pos, totalValue, ajax); });
			navigatorLast.click(function() { newNavigatorPos("last", posAction, navigator, pos, totalValue, ajax); });
			if (totalValue == 0) {
		  	navigatorFirst.addClass( "ui-state-disabled" );
		  	navigatorPrev.addClass( "ui-state-disabled" );
		  	navigatorNext.addClass( "ui-state-disabled" );
		  	navigatorLast.addClass( "ui-state-disabled" );
			} else {
				navigatorTotal.val(totalValue);
				var posValue = 0;
				if(pos != null && pos.val() != null) {
					posValue = pos.val();
				}
				if(navigatorPos != null) {
					navigatorPos.val(parseInt(posValue) + 1);
				}
				if (posValue == 0) {
	  	  	navigatorFirst.addClass( "ui-state-disabled" );
	  		  navigatorPrev.addClass( "ui-state-disabled" );
				} else {
		  	  navigatorFirst.removeClass( "ui-state-disabled" );
		  	  navigatorPrev.removeClass( "ui-state-disabled" );
				}
				if (posValue >= (totalValue-1)) {
	  		  navigatorNext.addClass( "ui-state-disabled" );
	  		  navigatorLast.addClass( "ui-state-disabled" );
				} else {
		  	  navigatorNext.removeClass( "ui-state-disabled" );
		  	  navigatorLast.removeClass( "ui-state-disabled" );
				}
			}
		}
	}
	
	function newNavigatorPos(navFunction, posAction, navigator, pos, totalValue, ajax) {
		if (navigator != null && navigator.attr("id") != null) {
		  if (navFunction == null) {
		  	navFunction = "next";
		  }
			var posValue = 0;
			var navigatorPos = $("#" + navigator.attr("id") + "Pos");
			if(navigatorPos != null && navigatorPos.val() != null) {
				posValue = navigatorPos.val();
			}
			var newPos = posValue;
			if (navFunction == "first") {
				newPos = 1; 
			} else if (navFunction == "prev") {
				newPos = parseInt(posValue) - 1; 
			} else if (navFunction == "next") {
				newPos = parseInt(posValue) + 1; 
			} else if (navFunction == "last") {
				newPos = parseInt(totalValue) - 1; 
			}
			pos.val(newPos - 1);
			if (ajax) {
				submitNavigatorAjax(posAction, navigator, pos, totalValue);
			} else {
				submitNavigator(posAction, navigator, pos, totalValue);
			}
		}
	}
	
	function submitNavigator(posAction, navigator, pos, totalValue) {
		$("#" + posAction).click();
	}

	function submitNavigatorAjax(posAction, navigator, pos, totalValue) {
		var form = $(navigator).parents("form");
		var posName = pos.attr("name");
		if (posName == null || posName == "") {
			posName = pos.attr("id");
		}
		var posValue = pos.attr("value");
		if (posValue == null || posValue == "") {
			posValue = "0";
		}
		var url = form.attr('action') + "?" + posAction + "=&" + posName + "=" + posValue;
		var newNavigator = null;
		$.ajax({
		 	url: url,
	   	success: function(data) {
		 		$("#" + form.attr("id")).html($($.parseHTML(data)).find("#" + form.attr("id") + " > *"));
		 		newNavigator = $($.parseHTML(data)).find("#" + navigator.attr("id"));
			},
			complete: function() {
				refreshNavigator(posAction, newNavigator, pos, totalValue, true);
				}
			});
		}

  function datepicker(field) {
    $(field).datepicker({
      showOn: "button",
      buttonImage: "../img/calendar.gif",
      buttonImageOnly: true
    });
  }
