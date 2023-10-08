import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppStateService {

  constructor() { }

  public authState :any ={
    isAuthenticated : false,
    username : undefined,
    roles : undefined,
    token : undefined
  }
}
