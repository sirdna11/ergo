import React, { useState } from 'react';
import axios from 'axios';

function AddUser() {
  const [user, setUser] = useState({
    personalID: '',
    firstName: '',
    lastName: '',
    dateOfBirth: '',
    gender: ''
  });

  const handleChange = e => {
    setUser({
      ...user,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = e => {
    e.preventDefault();

    axios.post('http://localhost:8080/addUser', user)
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        console.log(error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Personal ID:
        <input type="text" name="personalID" onChange={handleChange} />
      </label>
      <label>
        First Name:
        <input type="text" name="firstName" onChange={handleChange} />
      </label>
      <label>
        Last Name:
        <input type="text" name="lastName" onChange={handleChange} />
      </label>
      <label>
        Date of Birth:
        <input type="date" name="dateOfBirth" onChange={handleChange} />
      </label>
      <label>
        Gender:
        <select name="gender" onChange={handleChange}>
          <option value="">Select...</option>
          <option value="MALE">Male</option>
          <option value="FEMALE">Female</option>
        </select>
      </label>
      <button type="submit">Add User</button>
    </form>
  );
}

export default AddUser;
