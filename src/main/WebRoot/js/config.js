jQuery.ajaxSettings.traditional = true;

jconfirm.defaults = {
		title : 'INFO',
		type : 'default',
		content : 'Click ok to continue!',
		buttons : {},
		defaultButtons : {
			ok : {
				// text :"确定",
				action : function() {
				}
			},
			close : {
				// text:"取消",
				action : function() {
				}
			}
		},
		contentLoaded : function(data, status, xhr) {
		},
		icon : '',
		bgOpacity : null,
		theme : 'light',// 'material', 'supervan','bootstrap'
		animation : 'bottom',
		closeAnimation : 'top',
		animationSpeed : 400,
		animationBounce : 1.2,
		rtl : false,
		container : 'body',
		containerFluid : false,
		backgroundDismiss : false,
		backgroundDismissAnimation : 'shake',
		autoClose : false,
		closeIcon : true,
		closeIconClass : false,
		columnClass : 'col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1',
		boxWidth : '50%',
		useBootstrap : true,
		bootstrapClasses : {
			container : 'container',
			containerFluid : 'container-fluid',
			row : 'row',
		},
		onContentReady : function() {
		},
		onOpenBefore : function() {
		},
		onOpen : function() {
		},
		onClose : function() {
		},
		onDestroy : function() {
		},
		onAction : function() {
		}
	};