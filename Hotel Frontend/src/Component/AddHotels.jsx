import { useEffect, useState } from "react" 
import { addHotel, getHotel, updateHotel } from "../Service/HotelService"
import { useNavigate,useParams } from "react-router-dom"

const AddHotels = () => {
const [hotel_name, setName] = useState('')
const [hotel_gst, setGst] = useState('')
const [hotel_address, setAddress] = useState('')
const [hotel_manager, setManager] = useState('')
const [hotel_owner, setOwner] = useState('')
const [hotel_rating, setRating] = useState('')

const navigator = useNavigate();
const param = useParams();
console.log(param);
const {h_id} = param

useEffect(()=>{ 
    console.log(h_id);
    if(h_id){
        getHotel(h_id).then((response)=>{
            console.log(response.data);
        setName(response.data.hotel_name)
        setGst(response.data.hotel_gst)
        setAddress(response.data.hotel_address)
        setManager(response.data.hotel_manager)
        setOwner(response.data.hotel_owner)
        setRating(response.data.hotel_rating)  
    }).catch(error =>{
        console.error(error);
    })
 }
 else{
    console.log("etho error pa ")
 }
},[h_id]);

function handleHotelName(e){
setName(e.target.value);
}

function handleHotelGst(e){
    setGst(e.target.value);
}

function handleHotelAddress(e){
    setAddress(e.target.value);
}

function handleHotelManager(e){
    setManager(e.target.value);
}

function handleHotelOwner(e){
    setOwner(e.target.value);
}

function handleHotelRating(e){
    setRating(e.target.value);
}

function saveOrUpdateHotel(e){
    e.preventDefault();

    const hotel ={hotel_name,hotel_address,hotel_manager,hotel_owner,hotel_gst,hotel_rating}
    console.log(hotel);

    if(h_id){
        updateHotel(h_id,hotel).then((response)=>{
            console.log(response.data);
            navigator('/hotels')
        }).catch(error=>{
            console.error(error)
        })
    }
    
    else{
    addHotel(hotel).then((response)=>{
        console.log(response.data);
        navigator('/hotels')
    }).catch(error=>{4
            console.error(error)
        })
}
}
function pageTitle(){
    if(h_id){
        return<h2 className='text-center'>Update Hotel</h2>
    }
    else{
        return <h2 className='text-center'>Add Hotel</h2>

    }
}


    return (
<div>
    <div className='container'>
    
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
            {
                pageTitle()
            }

                    <div className='card-body' >
                        <form>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Hotel Name</label>
                                <input 
                                type="text"
                                placeholder='Enter Hotel Name'
                                name='hotel_name'
                                value={hotel_name}
                                className='form-control'
                                onChange={handleHotelName}/>
                            </div>

                             <div className='form-group mb-2'>
                                <label className='form-label'>Hotel GST</label>
                                <input 
                                type="text"
                                placeholder='Enter Hotel GST NO'
                                name='hotel_gst'
                                value={hotel_gst}
                                className='form-control'
                                onChange={handleHotelGst}/>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'>Hotel Address</label>
                                <input 
                                type="text"
                                placeholder='Enter Hotel Address'
                                name='hotel_address'
                                value={hotel_address}
                                className='form-control'
                                onChange={handleHotelAddress}/>
                            </div>

                             <div className='form-group mb-2'>
                                <label className='form-label'>Hotel Manager</label>
                                <input 
                                type="text"
                                placeholder='Enter Hotel Manager'
                                name='hotel_manager'
                                value={hotel_manager}
                                className='form-control'
                                onChange={handleHotelManager}/>
                            </div>

                             <div className='form-group mb-2'>
                                <label className='form-label'>Hotel Owner</label>
                                <input 
                                type="text"
                                placeholder='Enter Hotel Owner'
                                name='hotel_owner'
                                value={hotel_owner}
                                className='form-control'
                                onChange={handleHotelOwner}/>
                            </div>

                              <div className='form-group mb-2'>
                                <label className='form-label'>Hotel Rating</label>
                                <input 
                                type="number"
                                placeholder='Enter Hotel Rating'
                                name='hotel_rating'
                                value={hotel_rating}
                                className='form-control'
                                onChange={handleHotelRating}/>
                            </div>

                            <button className='btn btn-success' onClick={saveOrUpdateHotel}>Submit</button>
                        </form>
                    </div>
            </div>
        </div>
    </div>
</div>
)



}

export default AddHotels