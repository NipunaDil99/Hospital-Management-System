import { Injectable } from '@angular/core';
import { PatientModel } from '../models/patient.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
	//private _baseUrl = 'http://hospitalmanagementsystem1-env.eba-k97j3tu3.ap-south-1.elasticbeanstalk.com/api/v1/patient';
  private _baseUrl = 'http://localhost:8080/api/v1/patient';

	constructor(private http: HttpClient) {}

	getPatient(){
		return this.http.get<PatientModel[]>(`${this._baseUrl}/getPatient`);
	}
	createPatient(patient: PatientModel){
		return this.http.post(`${this._baseUrl}/savePatient`,patient);
	}

	deletePatient(id: any){
		return this.http.delete<string>(`${this._baseUrl}/deletePatient/`+id);
	}
	update(id: any, patient: PatientModel){
		return this.http.put<PatientModel>(`${this._baseUrl}/updatePatient/`+id,patient)
	}
	getPatientById(id: any){
		return this.http.get<PatientModel[]>(`${this._baseUrl}/getPatientId/`+id);

	}

}
