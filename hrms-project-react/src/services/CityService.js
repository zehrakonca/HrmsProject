import axios from "axios";

export default class CityService{
    urlBase = "http://localhost:8080/api/cities";

    getAllCities(){
        return axios.get("http://localhost:8080/api/cities/getAll");
    }


}