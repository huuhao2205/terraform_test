const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000;

app.use(bodyParser.json());

app.post('/api/login', (req, res) => {
  const { username, password } = req.body;

  const response = {
    success: false,
    message: 'Invalid username or password.'
  };

  if (username === 'user' && password === 'password') {
    response.success = true;
    response.message = 'Login successful!';
  }

  res.json(response);
});

app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});
