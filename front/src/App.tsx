import { useState, useEffect } from 'react';
import axios from "axios";

function App() {
  const [count, setNumCount] = useState<number>(0);

  const fetchCount = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/count?countId=1`);
      setNumCount(response.data.countNum);
    } catch (error) {
      console.error("Error fetching count:", error);
    }
  };

  const onIncrease = async () => {
    try {
      const response = await axios.post(`http://localhost:8080/count/incread`, {
        countId: 1,
        countNum: count
      });
      setNumCount(response.data.countNum);
    } catch (error) {
      console.error("Error increasing count:", error);
    }
  };

  const onDecrease = async () => {
    try {
      const response = await axios.post(`http://localhost:8080/count/decread`, {
        countId: 1,
        countNum: count
      });
      setNumCount(response.data.countNum);
    } catch (error) {
      console.error("Error decreasing count:", error);
    }
  };

  useEffect(() => {
    fetchCount();
  }, []);

  return (
    <div className="App">
      <h1>{count}</h1>
      <button onClick={onIncrease}>+1</button>
      <button onClick={onDecrease}>-1</button>
    </div>
  );
}

export default App;
