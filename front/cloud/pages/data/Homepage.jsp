<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <title>jsTree test</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jstree/3.0.9/themes/default/style.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jstree/3.3.5/jstree.min.js"></script>

</head>


<body>
<div class="page-header">
    <h2 style="color:darkblue">Topic hierarchy</h2> </div>
<div class="container" id="content">
<div class="row page" id="demo" style="display:block;">
<div class="col-md-12">
<div class="row">
					<div class="col-md-6 col-sm-8 col-xs-8">
						<button type="button" class="btn btn-primary" onclick="demo_create();"><i class="glyphicon glyphicon-asterisk"></i> Create</button>
						<button type="button" class="btn btn-primary" onclick="demo_rename();"><i class="glyphicon glyphicon-pencil"></i> Rename</button>
						<button type="button" class="btn btn-primary" onclick="demo_delete();"><i class="glyphicon glyphicon-remove"></i> Delete</button>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-4" style="text-align:right;">
						<input type="text" value="" style="box-shadow:inset 0 0 4px #eee; width:180px; margin:0; padding:6px 12px; border-radius:4px; border:1px solid darkblue; font-size:1.1em;" id="demo_q" placeholder="Search" />
					</div>
				</div>

<div id="jstree_demo" class="demo" style="margin-top:1em; min-height:200px;"></div>
</div></div></div>
<script>
function demo_create() {
	var ref = $('#jstree_demo').jstree(true),
		sel = ref.get_selected();
	if(!sel.length) {$("#jstree_demo").each(
			function(){alert("No node selected"); return false;}
	); }
	sel = sel[0];
	sel = ref.create_node(sel, {"type":"file"});
	if(sel) {
		ref.edit(sel);
	}
};
function demo_rename() {
	var ref = $('#jstree_demo').jstree(true),
		sel = ref.get_selected();
	if(!sel.length) {$("#jstree_demo").each(
			function(){alert("No node selected"); return false;}
	); }
	sel = sel[0];
	ref.edit(sel);
};
function demo_delete() {
	var ref = $('#jstree_demo').jstree(true),
		sel = ref.get_selected();
	if(!sel.length) {$("#jstree_demo").each(
			function(){alert("No node selected"); return false;}
			); }
	
	ref.delete_node(sel);
};
$(function () {
	var to = false;
	$('#demo_q').keyup(function () {
		if(to) { clearTimeout(to); }
		to = setTimeout(function () {
			var v = $('#demo_q').val();
			$('#jstree_demo').jstree(true).search(v);
		}, 250);
	});

	$('#jstree_demo')
		.jstree({
			"core" :
			{   
				"check_callback" : true,
				'force_text' : true,
				'data' : {
		            "url" : "//www.jstree.com/fiddle/"
		        }
			},
			
			"plugins" : [ "contextmenu", "dnd", "search", "types", "wholerow" ]
		});
});
</script>
	
</body>
</html>