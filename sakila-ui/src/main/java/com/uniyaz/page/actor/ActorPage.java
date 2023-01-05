package com.uniyaz.page.actor;

import com.uniyaz.actor.domain.Actor;
import com.uniyaz.actor.service.ActorService;
import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

import java.util.Date;
import java.util.List;

public class ActorPage extends VerticalLayout{

    private HorizontalLayout buttonLayout;
    private FormLayout filterFormLayout;
    private VerticalLayout tableLayout;
    private FormLayout formLayout;

    private TextField idFiltre;
    private TextField firstNameFilter;

    private TextField id;
    private TextField firstName;
    private TextField lastName;

    private Table table;

    private Button saveButton;
    private Button deleteButton;

    public ActorPage() {

        setMargin(true);
        setSpacing(true);

        buildFilterFormLayout();
        addComponent(filterFormLayout);

        buildTableLayout();
        addComponent(tableLayout);

        buildFormLayout();
        addComponent(formLayout);

        buildButtonLayout();
        addComponent(buttonLayout);

        fillTable();
    }

    private void buildFilterFormLayout() {
        filterFormLayout = new FormLayout();
    }

    private void buildTableLayout() {
        tableLayout = new VerticalLayout();

        buildTable();
        tableLayout.addComponent(table);
    }

    private void buildTable() {
        table = new Table();
        table.setSelectable(true);

        table.addContainerProperty("firstName", String.class, null);
        table.addContainerProperty("lastName", String.class, null);
        table.addContainerProperty("lastUpdate", Date.class, null);

        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                Actor actor = (Actor) itemClickEvent.getItemId();
                fillFormLayoutByActor(actor);
            }
        });
    }

    private void fillFormLayoutByActor(Actor actor) {

        id.setValue(actor.getId().toString());
        firstName.setValue(actor.getFirstName());
        lastName.setValue(actor.getLastName());
    }

    private void buildFormLayout() {

        formLayout = new FormLayout();

        id = new TextField();
        id.setCaption("Id");
        formLayout.addComponent(id);

        firstName = new TextField();
        firstName.setCaption("Fİrst Name");
        formLayout.addComponent(firstName);

        lastName = new TextField();
        lastName.setCaption("Last Name");
        formLayout.addComponent(lastName);
    }

    private void buildButtonLayout() {

        buttonLayout = new HorizontalLayout();

        buildSaveButton();
        buttonLayout.addComponent(saveButton);
    }

    private void buildSaveButton() {
        saveButton = new Button();
        saveButton.setCaption("Save");
        saveButton.setIcon(FontAwesome.SAVE);
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Actor actor = new Actor();

                if (!id.getValue().equals("")) {
                    actor.setId(new Long(id.getValue()));
                }
                actor.setFirstName(firstName.getValue());
                actor.setLastName(lastName.getValue());
                actor.setLastUpdate(new Date());

                ActorService actorService = new ActorService();
                actorService.save(actor);

                fillTable();
            }
        });
    }

    private void fillTable() {
        table.removeAllItems();
        ActorService actorService = new ActorService();
        List<Actor> actorList = actorService.findAll();

        for (Actor actor : actorList) {
            Item item = table.addItem(actor);
            item.getItemProperty("firstName").setValue(actor.getFirstName());
            item.getItemProperty("lastName").setValue(actor.getLastName());
            item.getItemProperty("lastUpdate").setValue(actor.getLastUpdate());
        }
    }
}