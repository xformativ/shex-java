/*******************************************************************************
 * Copyright (C) 2018 Université de Lille - Inria
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package fr.inria.lille.shexjava.validation;

import java.util.List;
import java.util.Set;

import org.apache.commons.rdf.api.RDFTerm;
import org.apache.commons.rdf.api.Triple;

import fr.inria.lille.shexjava.schema.Label;
import fr.inria.lille.shexjava.util.Pair;

/** A set of associations (resource, shape labels).
 * Is produced as result of a validation, see {@link ValidationAlgorithm}
 * 
 * @author Iovka Boneva
 * @author Antonin Durey
 * @author Jérémie Dusart
 */
public interface Typing {

	/** Checks whether a node-label association belongs to the typing. 
	 * 
	 * @param node
	 * @param label
	 */
	public boolean contains(RDFTerm node, Label label);
	
	/** Returns the typing as a set of pairs (node, label). Use for testing purpose.
	 * 
	 */
	public Set<Pair<RDFTerm, Label>> asSet(); // For testing purposes
	
	/** add the match (list of neighbor and triple constraint pair) for the node-label association to the typing.
	 * 
	 * @param node
	 * @param shape
	 * @return
	 */
	public void setMatch(RDFTerm node, Label label, List<Pair<Triple,Label>> match);
	
	/** return the match (list of neighbor and triple constraint pair) for the node-label association.
	 * 
	 * @param node
	 * @param shape
	 * @return
	 */
	public List<Pair<Triple,Label>> getMatch(RDFTerm node, Label label);
	
	/** remove the match (list of neighbor and triple constraint pair) for the node-label association to the typing.
	 * 
	 * @param node
	 * @param shape
	 * @return
	 */
	public void removeMatch(RDFTerm node, Label label);

}