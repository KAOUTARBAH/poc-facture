import { Prestation } from "./prestation.model";

export interface Facture {
  id?: number;
  customerRef?: string;
  customerContact ?: string ; 
	dueDate ?: Date ; 
	emissionDate ?: Date ; 
  prestation :Prestation ;
}
