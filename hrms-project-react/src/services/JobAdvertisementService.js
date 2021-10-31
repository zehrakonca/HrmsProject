import axios from "axios";

export default class JobAdvertisementService{
    getJobAdvertisementsByIdTrue(){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getByStatuIdTrue")
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

    getJobAdvertisementsByIdFalse(){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getByStatuIdFalse")
    }

    getJobAdvertisements(){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getAll")
    }

    updateJobAdvertisementStatu(advertisementId){
        return axios.get("http://localhost:8080/api/jobAdvertisements/updateStatu", advertisementId)
    }
}