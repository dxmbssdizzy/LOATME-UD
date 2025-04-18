document.addEventListener('DOMContentLoaded', () => {
  const loginForm = document.getElementById('login-form');
  const createForm = document.getElementById('create-form');
  const showCreateBtn = document.getElementById('show-create');
  const showLoginBtn = document.getElementById('show-login');

  showCreateBtn.addEventListener('click', () => {
    loginForm.classList.remove('active');
    createForm.classList.add('active');
  });

  showLoginBtn.addEventListener('click', () => {
    createForm.classList.remove('active');
    loginForm.classList.add('active');
  });

  loginForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const email = loginForm.querySelector('input[type="email"]').value;
    const password = loginForm.querySelector('input[type="password"]').value;

    try {
      const response = await fetch('http://localhost:8080/api/users/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password }),
      });

      if (response.ok) {
        alert('Inicio de sesión exitoso.');
      } else {
        const error = await response.text();
        alert('Error: ' + error);
      }
    } catch (error) {
      alert('Error de conexión con el servidor.');
    }
  });

  createForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = createForm.querySelector('input[type="text"]').value;
    const email = createForm.querySelector('input[type="email"]').value;
    const age = parseInt(createForm.querySelector('input[type="number"]').value, 10);
    const password = createForm.querySelector('input[type="password"]').value;

    try {
      const response = await fetch('http://localhost:8080/api/users/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, email, age, password }),
      });

      if (response.ok) {
        alert('Usuario registrado exitosamente.');
        createForm.reset();
        createForm.classList.remove('active');
        loginForm.classList.add('active');
      } else {
        const error = await response.text();
        alert('Error: ' + error);
      }
    } catch (error) {
      alert('Error de conexión con el servidor.');
    }
  });
});
