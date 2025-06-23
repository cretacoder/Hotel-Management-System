import axios from "axios";

const getAllHotel_Url = 'http://localhost:8080/Hotel/getAllHotel';

export const listHotels = () => axios.get(getAllHotel_Url);

const addHotel_Url ='http://localhost:8080/Hotel/register';
export const addHotel = (hotel) => axios.post(addHotel_Url,hotel)

const getbyId ='http://localhost:8080/Hotel/getById?h_id='
export const getHotel =(h_id) =>axios.get(getbyId+h_id)
const updatebyId = 'http://localhost:8080/Hotel/updateById?h_id='
export const updateHotel =(h_id,hotel)=> axios.put(updatebyId+h_id,hotel)

const deleteById ='http://localhost:8080/Hotel/delete?h_id='
export const deleteHotel =(h_id) =>axios.delete(deleteById+h_id)

