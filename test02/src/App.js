import { useEffect, useState } from "react";


function App() {
  const [hotCoffeeObj, setHotCoffeeObj] = useState([]);

  const fetchData = async () => {
    try {
      const response = await fetch('https://api.sampleapis.com/coffee/hot');
      const data = await response.json();
      setHotCoffeeObj(data);
    } catch (error) {
      console.error('Error fetching hot coffee data:', error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  console.log("==== coffee ==== ");
  console.log(hotCoffeeObj);

  return (
    <h1>done</h1>
  );
}


export default App;
