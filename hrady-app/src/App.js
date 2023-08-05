import React, { useEffect, useState } from 'react';

function App() {
  const [data, setData] = useState(null);

  useEffect(() => {
    // Function to fetch JSON data from the REST endpoint
    async function fetchData() {
      try {
        const response = await fetch('http://localhost:8080/');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const jsonData = await response.json();
        setData(jsonData);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }

    // Call the fetchData function when the component mounts
    fetchData();
  }, []);

  return (
    <div>
      <h1>Hrady České republiky</h1>
      {data ? (
	    data.map((castle, index) => {
		  return (
            <div key={index}>
			
				<a href={"hrad\\" + castle.folder}>{castle.name}</a>
				<br/>
            </div>
			);
	  }
        //<pre>{JSON.stringify(data, null, 2)}</pre>
      )) : (
        <p>Loading data...</p>
      )}
    </div>
  );
}

export default App;

