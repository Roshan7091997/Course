<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<div class="container">
  <h2>Login</h2>
  <form action="/app/jsplogin" method="post">
    <input type="text" name="username" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password" required>
    <select name="userType" required>
      <option value="">Select Role</option>
      <option value="admin">Admin</option>
      <option value="teacher">Teacher</option>
      <option value="student">Student</option>
    </select>
    <input type="submit" value="Login">
  </form>
  <div class="register-link">
    <p>Don't have an account? <a href="registration.html">Register</a></p>
    <p>Register as <a href="teacher_registration.html">Teacher</a> or <a href="student_registration.html">Student</a></p>
  </div>
</div>
</body>
</html>
