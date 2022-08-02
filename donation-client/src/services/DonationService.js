import axios from 'axios';

const DONATION_BASE_API_URL = 'http://localhost:8083/api/v1/donations';

export function getAllDonations(){
    return axios.get(DONATION_BASE_API_URL);
}

export function createDonation(donations){
    return axios.post(DONATION_BASE_API_URL,campers);
}

export function getById(id){
    return axios.get(`${DONATION_BASE_API_URL}/${id}`);
}

export function updateDonation(id, donations){
    return axios.put(`${DONATION_BASE_API_URL}/${id}`, donation);
}

export function deleteDonation(id){
    return axios.delete(`${DONATION_BASE_API_URL}/${id}`);
}
