import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {

  const [count, setCount] = useState(0);

  useEffect(() => {
    axios.get('http://localhost:8000/api/count')
        .then((response) => {
          setCount(response.data.count);
        })
        .catch((error) => {
          console.error("Error fetching count:", error);
        });
  }, []);

  const increaseCount = () => {
    axios.post('http://localhost:8000/api/increase')
        .then((response) => {
          setCount(response.data.count);
        })
        .catch((error) => {
          console.error("Error increasing count:", error);
        });
  };

  const decreaseCount = () => {
    axios.post('http://localhost:8000/api/decrease')
        .then((response) => {
          setCount(response.data.count);
        })
        .catch((error) => {
          console.error("Error decreasing count:", error);
        });
  };

  return (
      <div>
        <h1>Count: {count}</h1>
        <button onClick={increaseCount}>+1</button>
        <button onClick={decreaseCount}>-1</button>
      </div>
  );
}

export default App;
