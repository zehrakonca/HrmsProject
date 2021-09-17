import axios from "axios";

export default class SectorService{
    urlBase = "http://localhost:8080/api/sectors";

    getAllSectors(){
        return axios.get("http://localhost:8080/api/sectors/getAll");
    }


}