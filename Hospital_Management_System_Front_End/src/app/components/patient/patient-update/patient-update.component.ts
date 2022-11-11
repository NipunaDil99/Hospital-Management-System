import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patient-update',
  templateUrl: './patient-update.component.html',
  styleUrls: ['./patient-update.component.css']
})
export class PatientUpdateComponent implements OnInit {

	id! : number;
	isUpdating = false;
	patient : any;

  constructor(private patientService: PatientService, private router: Router) { }

  ngOnInit(): void {
	this.id = JSON.parse(localStorage.getItem('id') || '{}');
	this.patientService.getPatientById(this.id).subscribe({
		next: (res) => {
			this.patient = res;
			console.log(this.patient.id);
		},
		error: (error) =>{
			console.log(error);
		},
	});
  }

  onSubmit(){
	console.log(this.patient);
	this.isUpdating = true;

	this.patientService.update(this.id,this.patient).subscribe({
		next: (res) => {
			if(res){
			this.isUpdating = false;
			alert("Patient Details Updated");
			console.log('response:'+res);
			this.router.navigate(["admin/patient-view"]);
		}
	},

	error: (err) => {
		this.isUpdating = false;
		console.log('error:' + err);
		alert("Doctor Details not updated !")
	}
	});
  }

}
