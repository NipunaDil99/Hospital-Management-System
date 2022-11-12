import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DoctorModel } from '../models/doctor.model';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private _baseUrl = 'http://hospitalmanagementsystem1-env.eba-k97j3tu3.ap-south-1.elasticbeanstalk.com/api/v1/doctor';

  constructor(private http: HttpClient) {}

  getList() {
    return this.http.get<DoctorModel[]>(`${this._baseUrl}/getDoctor`);
  }
  getDoctor(id:any) {
    return this.http.get<DoctorModel[]>(`${this._baseUrl}/getDoctorId/`+id);
  }

  create(doctor: DoctorModel) {
    return this.http.post(`${this._baseUrl}/saveDoctor`, doctor);
  }
  update(id:any, doctor: DoctorModel) {
    return this.http.put<DoctorModel>(`${this._baseUrl}/updateDoctor/`+id,doctor);
  }
  delete(id : any) {
    return this.http.delete<string>(`${this._baseUrl}/deleteDoctor/`+id);
  }
}
