import React, { useState } from 'react';

function MyComponent() {
  const [data, setData] = useState([]);
  const [personalID, setPersonalID] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [isError, setIsError] = useState(false);

  const fetchData = () => {
    setIsLoading(true);
    setIsError(false);

    fetch(`http://localhost:8080/getUser?personalID=${personalID}`)
      .then(response => {
        if (!response.ok) { throw response }
        return response.json();
      })
      .then(data => {
        setData(data);
        setIsLoading(false);
      })
      .catch(error => {
        console.error('Error:', error);
        setIsError(true);
        setIsLoading(false);
      });
  }

  const handleInputChange = (e) => {
    setPersonalID(e.target.value);
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    fetchData();
  }

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (isError) {
    return <div>Error occurred while fetching data</div>;
  }

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          Personal ID:
          <input type="text" value={personalID} onChange={handleInputChange} />
        </label>
        <button type="submit">Fetch Data</button>
      </form>
      
      <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Personal ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Date of Birth</th>
          <th>Gender</th>
        </tr>
      </thead>
      <tbody>
        {data.map((item, index) => (
          <tr key={index}>
            <td>{item.id}</td>
            <td>{item.personalID}</td>
            <td>{item.firstName}</td>
            <td>{item.lastName}</td>
            <td>{item.dateOfBirth}</td>
            <td>{item.gender}</td>
          </tr>
        ))}
      </tbody>
    </table>
    </div>
  );
}

export default MyComponent;
