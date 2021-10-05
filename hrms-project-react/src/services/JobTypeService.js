import axios from "axios";

export default class JobTypeService{
    urlBase = "http://localhost:8080/api/jobTypes";

    getAllJobTypes(){
        return axios.get("http://localhost:8080/api/jobTypes/getAll");
    }


}