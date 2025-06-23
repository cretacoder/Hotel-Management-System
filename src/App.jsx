import { useState } from "react";
import "./App.css";
import ListHotelsComponent from "./Component/ListHotelsComponent";
import Header from "./Component/Header";
import Footer from "./Component/Footer";
import AddHotels from "./Component/AddHotels";
import {BrowserRouter,Route,Routes} from 'react-router-dom'

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
    <BrowserRouter>
      <Header />
     <Routes>
        {/* https://localhost:3000 */}
      <Route path='/' element={ <ListHotelsComponent />}></Route>

        {/* https://localhost:3000/hotels */}
        <Route path ='/hotels' element={ <ListHotelsComponent />}></Route>
 
      {/* https://localhost:3000/hotels/add-hotel */}
      <Route path ='/add-hotel' element ={<AddHotels/>}></Route>

       {/* https://localhost:3000/update-hotel/1 */}
    <Route path ='/update-hotel/:h_id' element ={<AddHotels/>}></Route>

 
   </Routes>
      <Footer/>
    </BrowserRouter>
   
    </>
  );
}

export default App;
