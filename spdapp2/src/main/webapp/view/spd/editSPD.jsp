<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit | СПД <c:out value="${spd.alias}"/></title>
</head>

<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->

<body>
	<h1 align="center">СПД <c:out value="${spd.alias}"/> => Редактирование</h1>
	<p>
	<form class="form" role="form" action="spd" method="post">

		<input type="hidden" name="edit">
		<input type="hidden" name="id" value="${spd.id}">

		<table border="0" width="50%">
			<tr align="left">
				<th>Основные данные</th>
				<th>Адрес деятельности</th>
				<th>Информация о гос. регистрации</th>
			</tr>
			<tr>
				<td valign="top">
					<div class="form-group">
						<label for="surname" class="col-sm-10 control-label">Фамилия</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="surname"
								name="surname" placeholder="Введите фамилию" value="${spd.surname}">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-6 control-label">Имя</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="firstname"
								name="firstname" placeholder="Введите имя" value="${spd.firstname}">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-10 control-label">Отчество</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="lastname"
								name="lastname" placeholder="Введите отчество" value="${spd.lastname}">
						</div>
					</div>
					<div class="form-group">
						<label for="alias" class="col-sm-10 control-label">Короткое
							ФИО</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias"
								placeholder="Введите короткое ФИО" value="${spd.alias}">
						</div>
					</div>
					<div class="form-group">
						<label for="inn" class="col-sm-10 control-label">ИНН</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inn" name="inn"
								placeholder="Введите идентификационный номер" value="${spd.inn}">
						</div>
					</div>
					<div class="form-group">
						<label for="passport" class="col-sm-10 control-label">Паспорт</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="passport"
								name="passport" placeholder="Введите паспортные данные" value="${spd.passport}">
						</div>
					</div>
				</td>
				<td valign="top">
					<div class="form-group">
						<label for="country" class="col-sm-10 control-label">Страна</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="country"
								name="country" placeholder="Страна" value="${address.country}">
						</div>
					</div>
					<div class="form-group">
						<label for="region" class="col-sm-10 control-label">Область</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="region" name="region"
								placeholder="Область" value="${address.region}">
						</div>
					</div>
					<div class="form-group">
						<label for="city" class="col-sm-10 control-label">Населенный
							пункт</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="city" name="city"
								placeholder="Населенный пункт" value="${address.city}">
						</div>
					</div>
					<div class="form-group">
						<label for="street" class="col-sm-10 control-label">Улица</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="street" name="street"
								placeholder="Улица" value="${address.street}">
						</div>
					</div>
					<div class="form-group">
						<label for="building" class="col-sm-10 control-label">Номер
							дома</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="building"
								name="building" placeholder="Номер дома" value="${address.building}">
						</div>
					</div>
					<div class="form-group">
						<label for="flat" class="col-sm-10 control-label">Квартира</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="flat" name="flat"
								placeholder="Квартира" value="${address.flat}">
						</div>
					</div>
					<div class="form-group">
						<label for="zip" class="col-sm-10 control-label">Индекс</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zip" name="zip"
								placeholder="Индекс" value="${address.zip}">
						</div>
					</div>
				</td>
				<td valign="top">
					<div class="form-group">
						<label for="description" class="col-sm-10 control-label">Описание</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="description"
								name="description" placeholder="Описание" value="${regInfo.description}">
						</div>
					</div>
					<div class="form-group">
						<label for="dated" class="col-sm-10 control-label">Дата</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="dated"
								name="dated" placeholder="Дата" value="${regInfo.dated}">
						</div>
					</div>
				</td>
			</tr>
		</table>
		<table>
		<tbody>
			<tr>
				<div class="form-group">
					<form action="listAllSPD" method="get">
						<button type="submit" class = "btn btn-default">Вернуться к списку СПД</button>
					</form>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<label for="button" class="col-sm-10 control-label"></label>
					<div class="col-sm-offset-10 col-sm-10">
						<input type="submit" class="btn btn-success" id="button"
							value="Сохранить изменения">
					</div>
				</div>
			</tr>
			</tbody>
		</table>
	</form>
		
		
	<!-- ---------------------------------------------------------------------------------------- -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>