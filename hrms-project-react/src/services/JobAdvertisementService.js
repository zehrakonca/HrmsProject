import axios from "axios";

export default class JobAdvertisementService{
    getJobAdvertisements(){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getAll")
    }

    getJobAdvertisementsBySorted(){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getDetailsSorted")
    }

    getJobAdvertisementById(id){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getById?advertisementId="+id);
    }

    addAdvertisement(advertisement){
        return axios.post("http://localhost:8080/api/jobAdvertisements/add",advertisement);
    }
}