import React, { useState, useEffect } from "react";
import { listHotels,deleteHotel } from "../Service/HotelService";
import { useNavigate } from "react-router-dom";

const ListHotelsComponent = () => {

  const [hotels, setHotels] = useState([]);
    const navigator = useNavigate();


  useEffect(() => {
    getAllHotels();   
  }, []);

  function addNewHotel() {
    navigator('/add-hotel')
  }
function getAllHotels(){
 listHotels()
      .then((response) => {
        setHotels(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
}
  function updateHotel(h_id){
    navigator(`/update-hotel/${h_id}`)
  }
  function deleteHotels(h_id){
    deleteHotel(h_id).then((response)=>{
        getAllHotels();
    });
  }

  return (
  <div className=".container">
        <h2>List of Hotels</h2>
        <button className="btn btn-primary mb-2" onClick={addNewHotel}>Add Hotel</button>
    <table className="table table-striped table-bordered">
        <thead>
            <tr>
                <th>Hotel Id</th>
                <th>Hotel Name</th>
                <th>Hotel GST</th>
                <th>Hotel Adress</th>
                <th>Hotel Manager</th>
                <th>Hotel Owner</th>
                <th>Hotel Rating</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            {
                hotels.map(hotel=>
                    <tr key={hotel.hotel_id}>
                        <td>{hotel.hotel_id}</td>
                        <td>{hotel.hotel_name}</td>
                        <td>{hotel.hotel_gst}</td>
                        <td>{hotel.hotel_address}</td>
                        <td>{hotel.hotel_manager}</td>
                        <td>{hotel.hotel_owner}</td>
                        <td>{hotel.hotel_rating}</td>
                        <td><button className='btn btn-info' onClick={()=>updateHotel(hotel.hotel_id)}>Update</button>
                        <button className='btn btn-danger' onClick={()=>deleteHotels(hotel.hotel_id)} style={{marginLeft:10}}>Delete</button></td>

                    </tr>
                )
            }
        </tbody>
    </table>
    </div>);

};
export default ListHotelsComponent;
