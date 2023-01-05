package com.uniyaz.page.city;

import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.city.service.CityService;
import com.uniyaz.page.country.CountryComboBox;
import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

import java.util.Date;
import java.util.List;

public class CityPage extends VerticalLayout{

    private HorizontalLayout buttonLayout;
    private FormLayout filterFormLayout;
    private VerticalLayout tableLayout;
    private FormLayout formLayout;

    private TextField idFiltre;
    private TextField cityFilter;

    private TextField id;
    private TextField cityField;
    private CountryComboBox countryField;

    private Table table;

    private Button saveButton;
    private Button deleteButton;
    private Button searchButton;

    public CityPage() {

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

        CityService cityService = new CityService();
        List<City> cityList = cityService.findAll();
        fillTable(cityList);
    }

    private void buildFilterFormLayout() {
        filterFormLayout = new FormLayout();

        idFiltre = new TextField();
        idFiltre.setCaption("Id");
        filterFormLayout.addComponent(idFiltre);

        cityFilter = new TextField();
        cityFilter.setCaption("City");
        filterFormLayout.addComponent(cityFilter);

        buildSearchButton();
        filterFormLayout.addComponent(searchButton);
    }

    private void buildSearchButton() {

        searchButton = new Button();
        searchButton.setCaption("Search");
        searchButton.setIcon(FontAwesome.SEARCH);
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                CityQueryFilterDto cityQueryFilterDto = new CityQueryFilterDto();
                if (!idFiltre.getValue().equals("")) cityQueryFilterDto.setId(new Long(idFiltre.getValue()));
                if (!cityFilter.getValue().equals("")) cityQueryFilterDto.setCity(cityFilter.getValue());

                CityService cityService = new CityService();
                List<City> cityList = cityService.findAllByQueryFilterDto(cityQueryFilterDto);
                fillTable(cityList);
            }
        });
    }

    private void buildTableLayout() {
        tableLayout = new VerticalLayout();

        buildTable();
        tableLayout.addComponent(table);
    }

    private void buildTable() {
        table = new Table();
        table.setSelectable(true);

        table.addContainerProperty("id", Long.class, null);
        table.addContainerProperty("country", String.class, null);
        table.addContainerProperty("city", String.class, null);
        table.addContainerProperty("lastUpdate", Date.class, null);

        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                City city = (City) itemClickEvent.getItemId();
                fillFormLayoutByCity(city);
            }
        });
    }

    private void fillFormLayoutByCity(City city) {

        id.setValue(city.getId().toString());
        cityField.setValue(city.getCity());
    }

    private void buildFormLayout() {

        formLayout = new FormLayout();

        id = new TextField();
        id.setCaption("Id");
        formLayout.addComponent(id);

        cityField = new TextField();
        cityField.setCaption("City");
        formLayout.addComponent(cityField);

        countryField = new CountryComboBox();
        countryField.setCaption("Country");
        formLayout.addComponent(countryField);
    }

    private void buildButtonLayout() {

        buttonLayout = new HorizontalLayout();

        buildSaveButton();
        buttonLayout.addComponent(saveButton);

        buildDeleteButton();
        buttonLayout.addComponent(deleteButton);
    }

    private void buildSaveButton() {
        saveButton = new Button();
        saveButton.setCaption("Save");
        saveButton.setIcon(FontAwesome.SAVE);
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                City city = new City();

                if (!id.getValue().equals("")) {
                    city.setId(new Long(id.getValue()));
                }
                city.setCity(cityField.getValue());
                city.setLastUpdate(new Date());

                CityService cityService = new CityService();
                cityService.save(city);

                List<City> cityList = cityService.findAll();
                fillTable(cityList);
            }
        });
    }

    private void buildDeleteButton() {

        deleteButton = new Button();
        deleteButton.setCaption("Delete");
        deleteButton.setIcon(FontAwesome.TRASH);
        deleteButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                City city = new City();
                city.setId(new Long(id.getValue()));

                CityService cityService = new CityService();
                cityService.delete(city);

                List<City> cityList = cityService.findAll();
                fillTable(cityList);
            }
        });
    }

    private void fillTable(List<City> cityList) {

        table.removeAllItems();
        for (City city : cityList) {
            Item item = table.addItem(city);
            item.getItemProperty("id").setValue(city.getId());
            item.getItemProperty("country").setValue(city.getCountry().getCountry());
            item.getItemProperty("city").setValue(city.getCity());
            item.getItemProperty("lastUpdate").setValue(city.getLastUpdate());
        }
    }
}