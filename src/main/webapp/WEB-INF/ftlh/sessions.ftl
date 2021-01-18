<html>
<head>
	<title> FreeMarker Spring MVC Hello World</title>
	<style>
		.datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
		.datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
		.datatable tr {border:1px solid #888}
		.datatable td {padding:2px;border:1px solid #888}
		#content { padding 5px; margin: 5px; text-align: center}
		fieldset { width: 300px; padding: 5px; margin-bottom: 0; }
		legend { font-weight: bold; }
	</style>
</head>
<body>
<div id="header">
	<H2>
		Sessions page!
	</H2>
</div>

<div id="content">
	<table class="datatable">
		<tr>
			<th>Session ID</th>
			<th>Session Date</th>
			<th>Session Time</th>
			<th>Film</th>
			<th>Hall</th>
		</tr>
        <#list model["sessionsList"] as session>
			<tr>
				<td>${session.sessionId}</td>
				<td>${session.dateString}</td>
				<td>${session.timeString}</td>
				<td>${session.film.name}</td>
				<td>${session.hall.number}</td>
			</tr>
        </#list>
	</table>

	<div align="left">
		<h3>Save new session:</h3>
		<form method="post" action="/admin/panel/sessions/new">
			<p>Session date:
				<input type="date" id="session-date" name="sessionDate"
					   min="2020-01-01" max="2022-12-31"></p>
			<p>Session time:
				<input type="time" id="session-time" name="sessionTime"
					   min="09:00" max="22:00" required></p>

			<p>hall:
				<select name="hall">
                    <#list model["hallsList"] as hall>
						<option value=${hall.hallId}>${hall.number}</option>
                    </#list>
				</select>
			</p>

			<p>film:
				<select name="film">
                    <#list model["filmsList"] as film>
						<option value=${film.filmId}>${film.name}</option>
                    </#list>
				</select>
			</p>

			<p><input type="submit" value="Save"></p>
		</form>
	</div>
</div>
</body>
<script>
    document.getElementById('session-date').valueAsDate = new Date();
</script>
</html>
