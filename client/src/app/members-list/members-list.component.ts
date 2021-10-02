import { Component, OnInit } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { MembersService } from '../services/members.service';

export interface IMember {
  firstName : string;
  lastName : string;
  email : string;
  gender : string;
}

@Component({
  selector: 'app-members-list',
  templateUrl: './members-list.component.html',
  styleUrls: ['./members-list.component.scss']
})

export class MembersListComponent implements OnInit {

  constructor(private _membersService : MembersService) { }

  public members :IMember[] = [];

  displayedColumns: string[] = ['id',"firstName","lastName","email","gender"];

  ngOnInit(): void { 
    this._membersService.getMembers()
      .subscribe(data => this.members = data);
    //console.log(this._membersService.getMembers())
  }

}
