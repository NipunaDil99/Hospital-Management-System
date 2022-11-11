import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppointmentModel } from '../models/appointment.model';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private _baseUrl = 'http://hospitalmanagementsystem1-env.eba-k97j3tu3.ap-south-1.elasticbeanstalk.com/api/v1/appointment';

  constructor(private http: HttpClient) { }

  create(appointment : AppointmentModel) {
    return this.http.post(`${this._baseUrl}/saveAppointment`,appointment, {responseType: 'text'});
  }

  getList() {
    return this.http.get<AppointmentModel[]>(`${this._baseUrl}/getAppointments`);
  }

  delete(appointment_id : any) {
    return this.http.delete<string>(`${this._baseUrl}/deleteAppointment/`+appointment_id);
  }

  update(appointment_id: number,appointment: AppointmentModel) {
    return this.http.put<AppointmentModel>(`${this._baseUrl}/updateAppointment/`+appointment_id,appointment);
  }

  getAppointment(id:any) {
    return this.http.get<AppointmentModel[]>(`${this._baseUrl}/getAppointment/`+id);
  }
}
