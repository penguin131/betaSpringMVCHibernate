<html>
<head>
	<title> FreeMarker Spring MVC Hello World</title>
	<style>
		.datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
		.datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
		.datatable tr {border:1px solid #888}
		.datatable tr.odd {background-color:#eee}
		.datatable td {padding:2px;border:1px solid #888}
		#content { padding 5px; margin: 5px; text-align: center}
		fieldset { width: 300px; padding: 5px; margin-bottom: 0px; }
		legend { font-weight: bold; }
	</style>
</head>
<body>
<div id="header">
	<H2>
		FreeMarker Spring MVC Hello World
	</H2>
</div>

<div id="content">

	<table class="datatable">
		<tr>
			<th>Number</th>  <th>Seats count</th>
		</tr>
        <#list model["superList"] as hall>
			<tr>
				<td>${hall.number}</td> <td>${hall.seatsCount}</td>
			</tr>
        </#list>
	</table>

</div>
</body>
</html>
