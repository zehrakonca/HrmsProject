import axios from "axios";

export default class JobService{
    urlBase = "http://localhost:8080/api/jobs";

    getAllJobs(){
        return axios.get("http://localhost:8080/api/jobs/getAll");
    }


}