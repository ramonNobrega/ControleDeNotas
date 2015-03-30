<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	$(function() {
		$('#bl_menu').menu({
			position: {
				at:'left bottom',
			}
		});
	});
</script>
<style>
	.ui-menu .ui-menu-item {
		display: inline-block;
		float: none;
		margin: 1px 0;
		padding: 0;
		width: auto;
	}
	.ui-menu .ui-menu-item .ui-menu {
		margin: 1px 0 10px;
		padding: 0;
		width: auto;
	}
	.ui-menu .ui-menu-item .ui-menu  .ui-menu-item {
		float: none;
		margin: 1px 0 1px;
		padding: 0;
		width: auto;
	}
	.ui-menu .ui-menu-item .ui-menu .ui-menu-item .ui-menu {
		float: right;
		margin: 1px 0 10px 100px;
		padding: 0;
		max-width: 100px;
	}
</style>
<ul id="bl_menu">
</ul>
