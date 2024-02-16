<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16/02/2024
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>VitaHealt - Online | Registro de Medicos</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    h2{
      margin-top:  2rem;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Insertar Nuevo Perfil de Medico</h2>
  <form action="./registro_medico" method="post">
    <div class="form-group">
      <label for="nombreProfesional">Nombre del Profesional:</label>
      <input type="text" class="form-control" id="nombreProfesional" name="nombreProfesional" required>
    </div>
    <div class="form-group">
      <label for="apellidosProfesional">Apellidos del Profesional:</label>
      <input type="text" class="form-control" id="apellidosProfesional" name="apellidosProfesional" required>
    </div>
    <div class="form-group">
      <label for="especialidad">Especialidad:</label>
      <input type="text" class="form-control" id="especialidad" name="especialidad" required>
    </div>
    <div class="form-group">
      <label for="correoElectronico">Correo Electrónico:</label>
      <input type="text" class="form-control" id="correoElectronico" name="correoElectronico" required>
    </div>
    <div class="form-group">
      <label for="telefono">Teléfono:</label>
      <input type="text" class="form-control" id="telefono" name="telefono" required>
    </div>
    <button type="submit" class="btn btn-primary">Insertar Nuevo Médico</button>
  </form>
</div>
</body>
</html>
