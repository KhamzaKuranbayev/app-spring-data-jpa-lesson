package uz.digitalone.appspringdatajpalesson.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.digitalone.appspringdatajpalesson.entity.Car;
import uz.digitalone.appspringdatajpalesson.entity.Category;
import uz.digitalone.appspringdatajpalesson.repository.CarRepository;
import uz.digitalone.appspringdatajpalesson.repository.CategoryRepository;
import uz.digitalone.appspringdatajpalesson.rest.dto.CarDto;
import uz.digitalone.appspringdatajpalesson.rest.request.CarRequest;
import uz.digitalone.appspringdatajpalesson.rest.response.SingleResponse;
import uz.digitalone.appspringdatajpalesson.service.CarService;

import java.util.*;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/10/2022
 * Time: 10:28 PM
 */

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public SingleResponse save(CarRequest request) {
        if (repository.existsByName(request.getName()))
            return new SingleResponse(false, "Such Car Name is already exists!", HttpStatus.BAD_REQUEST);

        Set<Category> categorySet = new HashSet<>();
        request.getCategoryIdSet()
                .stream()
                .map(categoryRepository::findById)
                .forEachOrdered(optionalCategory -> optionalCategory.ifPresent(categorySet::add));

        Car savedCar = repository.save(new Car(
                        request.getName(),
                        request.getColor(),
                        request.getYear(),
                        request.getPrice(),
                        categorySet
                )
        );

        return new SingleResponse(true, "Car saved!", savedCar.getId());
    }

    @Override
    public SingleResponse findAll() {
        // Pageable
        List<Car> carList = repository.findAll();
        List<CarDto> list = new ArrayList<>();
        for (Car car : carList) {
            list.add(fromEntity(car));
        }
        return new SingleResponse(true, "Car List", list);
    }

    private CarDto fromEntity(Car car) {
        return new CarDto(

        );
    }
}
