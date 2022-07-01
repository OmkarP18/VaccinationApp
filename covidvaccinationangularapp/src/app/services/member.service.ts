import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Member } from '../model/member';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  url="http://localhost:7000/member";

  constructor(private http:HttpClient) { }

  addMemberWithAadhar(member:Member){
    return this.http.post(this.url+"/registerwithAdhar/",member);
  }
  
  addMemberWithPancard(member:Member){
    return this.http.post(this.url+"/registerwithPan/",member);
  }

  getMemberByAadhar(aadharNo:any){
    return this.http.get(this.url+"/findByAdharNo/",aadharNo);
  }

  getMemberByPan(PanNo:any){
    return this.http.get(this.url+"/findByAdharNo/",PanNo);
  }

  getAllMembers(){
    return this.http.get(this.url+"/findall");
  }

  updateMemberDetails(member:Member){
    return this.http.put(this.url+"/update",member);
  }

  
deleteMemberById(idCardId:any){
  return this.http.delete(this.url+"/delete/"+idCardId,{responseType:'text'});
}
}