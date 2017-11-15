/**
 * Objet cree pour retacer tous les communes
 * objet racine pour service HATEOS et faciliter la navigation dans le service Programmme
 */
package com.bootcamp.servicecrud.jpa.entities;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author soul
 */
@XmlRootElement(name = "communes")
public class Communes {

     protected Collection<Commune> communes;
    protected List<Link> links;

    @XmlElementRef
    public Collection<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(Collection<Commune> communes) {
        this.communes = communes;
    }

    @XmlElement(name = "link")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @XmlTransient
    public URI getNext() {
        if (links == null) {
            return null;
        }
        for (Link link : links) {
            if ("next".equals(link.getRel())) {
                return link.getUri();
            }
        }
        return null;
    }

    @XmlTransient
    public URI getPrevious() {
        if (links == null) {
            return null;
        }
        for (Link link : links) {
            if ("previous".equals(link.getRel())) {
                return link.getUri();
            }
        }
        return null;
    }
}
