<%--
  Created by IntelliJ IDEA.
  User: alumno
  Date: 8/2/24
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VitaHealt - Online | Registro de Paciente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        h2{
            margin-top:  2rem;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Insertar Nuevo Perfil de Paciente</h2>
    <form action="./insertarPaciente" method="post">
        <div class="form-group">
            <label for="nombrePaciente">Nombre del Paciente:</label>
            <input type="text" class="form-control" id="nombrePaciente" name="nombrePaciente" required>
        </div>
        <div class="form-group">
            <label for="apellidosPaciente">Apellidos del Paciente:</label>
            <input type="text" class="form-control" id="apellidosPaciente" name="apellidosPaciente" required>
        </div>
        <div class="form-group">
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
        </div>
        <div class="form-group">
            <label for="sexo">Sexo:</label>
            <input type="text" class="form-control" id="sexo" name="sexo" required>
        </div>
        <div class="form-group">
            <label for="direccion">Dirección:</label>
            <input type="text" class="form-control" id="direccion" name="direccion" required>
        </div>
        <div class="form-group">
            <label for="correoElectronico">Correo Electrónico:</label>
            <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" required>
        </div>
        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <input type="text" class="form-control" id="telefono" name="telefono" required>
        </div>
        <button type="submit" class="btn btn-primary">Insertar Nuevo Paciente</button>
    </form>
</div>
</body>
</html>