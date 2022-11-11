import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientModel } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patient-get-list',
  templateUrl: './patient-get-list.component.html',
  styleUrls: ['./patient-get-list.component.css']
})
export class PatientGetListComponent implements OnInit {

  isLoading = false;
	patientList: PatientModel[] | undefined;
	patient: any;

  constructor(private patientService: PatientService, private router: Router) { }

  ngOnInit(): void {
	this.getList();
  }

  getList(){
	this.isLoading = true;
	this.patientService.getPatient().subscribe({
		next:(res) => {
			this.patientList = res;
			this.isLoading = false;
			console.log(this.patientList);
		},
		error:(error)=>{
			console.log(error);
			this.isLoading=false;
		}
	});
  }

  delete(id: any){
	let text = "Do you want to delete this patient?"
	if(confirm(text) == true){
		this.patientService.deletePatient(id).subscribe({
			next: (res) => {
				console.log(res);
				if(res == null){
					alert("Employee deleted");
					console.log(res);
					this.getList();
					this.router.navigate(["admin/patient-view"]);
				}
			},
			error: (error)=>{
				console.log(error);
				this.isLoading = false;
				console.log(error);
				alert("Employee could not delete");
			},
		});
	}
  }

  edit(id: number){
	localStorage.setItem('id', JSON.stringify(id))
  }

}
