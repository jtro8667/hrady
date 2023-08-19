import React, { useEffect, useState } from 'react';

function App() {
  const [data, setData] = useState(null);

  useEffect(() => {
    // Function to fetch JSON data from the REST endpoint
    async function fetchData() {
      try {
        const response = await fetch('http://localhost:8080/hrad/Beistein');
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
      <h1>Hrad</h1>
      {data ? (
		  data.pictures.map((picture, index) => {
		  return (
            <div key={index}>{index}
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

