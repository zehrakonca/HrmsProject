import axios from "axios";

export default class ExperienceService{
    urlBase = "http://localhost:8080/api/experiences";

    getAllExperiences(){
        return axios.get("http://localhost:8080/api/experiences/getAll");
    }


}