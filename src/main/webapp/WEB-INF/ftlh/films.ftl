<html>
<head>
	<title> FreeMarker Spring MVC Hello World</title>
	<style>
		.datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
		.datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
		.datatable tr {border:1px solid #888}
		.datatable td {padding:2px;border:1px solid #888}
		#content { padding 5px; margin: 5px; text-align: center}
		.poster { max-width: 250px; max-height: 250px; }
		fieldset { width: 300px; padding: 5px; margin-bottom: 0; }
		legend { font-weight: bold; }
	</style>
</head>
<body>
<div id="header">
	<H2>
		Films page!
	</H2>
</div>

<div id="content">
	<table class="datatable">
		<tr>
			<th>Film name</th>  <th>Year</th> <th>Min age</th>  <th>Description</th> <th>Poster</th>
		</tr>
        <#list model["filmList"] as film>
			<tr>
				<form id="image-form" method="post" action="/admin/panel/films/savePoster" enctype="multipart/form-data">
					<td>${film.name}</td>
					<td>${film.year?int?c}</td>
					<td>${film.minAge}</td>
					<td>${film.description}</td>
					<td><img src="${film.imageLink}" class="poster"></td>
				</form>
			</tr>
        </#list>
	</table>

	<div align="left">
		<h3>Save new film:</h3>
		<form enctype="multipart/form-data" method="post" action="/admin/panel/films/save" id="addFilm-form">
			<p><input type="text" name="name" placeholder="name"></p>
			<p><input type="text" name="year" placeholder="year"></p>
			<p><input type="text" name="minAge" placeholder="minAge"></p>
			<p><input type="text" name="description" placeholder="description"></p>
			<p><input id="download-image" type="file" name="uploadFile"/></p>
			<p><input type="submit" value="Save"></p>
		</form>
	</div>
</div>
</body>
<script type="text/javascript">
    document.getElementById('addFilm-form').onsubmit = function onSubmit() {

        const file = document.getElementById('download-image').files[0];
        if (file != null && file.size > 0) {
            const fileType = file['type'];
            const validImageTypes = ['image/gif', 'image/jpeg', 'image/png', 'image/bmp'];
            if (!validImageTypes.includes(fileType)) {
                alert("Invalid image type");
                return false;
            }
            if (file.size > 1024 * 1024 * 5) {
                alert("Max file size 5 MiB!");
                return false;
            }
		}
    };
</script>
</html>
