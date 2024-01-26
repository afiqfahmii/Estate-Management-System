package com.project.estatemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Bond;
import com.project.estatemanagementsystem.entity.property.Cash;
import com.project.estatemanagementsystem.entity.property.Debenture;
import com.project.estatemanagementsystem.entity.property.Insurance;
import com.project.estatemanagementsystem.entity.property.Share;
import com.project.estatemanagementsystem.entity.property.UnitTrust;
import com.project.estatemanagementsystem.entity.property.Vehicle;
import com.project.estatemanagementsystem.entity.property.land.Caveat;
import com.project.estatemanagementsystem.entity.property.land.Charge;
import com.project.estatemanagementsystem.entity.property.land.Easement;
import com.project.estatemanagementsystem.entity.property.land.Lease;
import com.project.estatemanagementsystem.entity.property.land.Maintenance;
import com.project.estatemanagementsystem.entity.property.land.Mortgage;
import com.project.estatemanagementsystem.entity.property.land.QuitRent;
import com.project.estatemanagementsystem.entity.property.land.RightOfWay;
import com.project.estatemanagementsystem.entity.property.land.Tenancy;
import com.project.estatemanagementsystem.entity.property.land.Transfer;
import com.project.estatemanagementsystem.entity.property.land.UtilitiesBill;
import com.project.estatemanagementsystem.entity.property.land.Waqf;
import com.project.estatemanagementsystem.service.PropertyService;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.BondService;
import com.project.estatemanagementsystem.service.propertyservice.CashService;
import com.project.estatemanagementsystem.service.propertyservice.DebentureService;
import com.project.estatemanagementsystem.service.propertyservice.InsuranceService;
import com.project.estatemanagementsystem.service.propertyservice.ShareService;
import com.project.estatemanagementsystem.service.propertyservice.UnitTrustService;
import com.project.estatemanagementsystem.service.propertyservice.VehicleService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.CaveatService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.ChargeService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.EasementService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.LeaseService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.MaintenanceService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.MortgageService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.QuitRentService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.RightOfWayService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.TenancyService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.TransferService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.UtilitiesBillService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.WaqfService;

@Controller
public class PropertyController {
    
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;
    @Autowired
    private CaveatService caveatService;
    @Autowired
    private ChargeService chargeService;
    @Autowired
    private EasementService easementService;
    @Autowired
    private LeaseService leaseService;
    @Autowired
    private MaintenanceService maintenanceService;
    @Autowired
    private MortgageService mortgageService;
    @Autowired
    private QuitRentService quitRentService;
    @Autowired
    private RightOfWayService rightOfWayService;
    @Autowired
    private TenancyService tenancyService;
    @Autowired
    private TransferService transferService;
    @Autowired
    private UtilitiesBillService utilitiesBillService;
    @Autowired
    private WaqfService waqfService;
    @Autowired
    private BondService bondService;
    @Autowired
    private CashService cashService;
    @Autowired
    private DebentureService debentureService;
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private ShareService shareService;
    @Autowired
    private UnitTrustService unitTrustService;
    @Autowired
    private VehicleService vehicleService;

    
    public PropertyController(PropertyService propertyService, UserService userService) {
        this.propertyService = propertyService;
        this.userService = userService;
    }

    private User getLoggedInUser() {
        return userService.getCurrentUser();
    }

    //display list of properties
    @GetMapping("/propertyList")
    public String propertyList(Model model){
        User loggedInUser = getLoggedInUser();
        List<Property> propertyList = propertyService.getPropertiesByUser(loggedInUser);

        model.addAttribute("propertyList", propertyList);
        return "propertyList";
    }

    //BOND
    @GetMapping("/formbond")
    public String formbond(Model model){
        User loggedInUser = getLoggedInUser();

        Property bond = new Bond();
        bond.setUser(loggedInUser);

        model.addAttribute("Bond", bond);
        return "formBond";
    }

    @PostMapping("/saveBond")
    public String saveBond(@ModelAttribute("Bond") Bond bond, Model model){
        bondService.saveBond(bond);
        model.addAttribute("successMessage", "Bond saved successfully!");

        return "redirect:/propertyList";
    }

    //CAVEAT
    @GetMapping("/formcaveat")
    public String formcaveat(Model model){
        User loggedInUser = getLoggedInUser();

        Property caveat = new Caveat();
        caveat.setUser(loggedInUser);

        model.addAttribute("Caveat", caveat);
        return "formCaveat";
    }

    @PostMapping("/saveCaveat")
    public String saveCaveat(@ModelAttribute("Caveat") Caveat caveat){
        caveatService.saveCaveat(caveat);

        return "redirect:/propertyList";
    }

    //CHARGE
    @GetMapping("/formcharge")
    public String formcharge(Model model){
        User loggedInUser = getLoggedInUser();

        Property charge = new Charge();
        charge.setUser(loggedInUser);

        model.addAttribute("Charge", charge);
        return "formCharge";
    }

    @PostMapping("/saveCharge")
    public String saveCharge(@ModelAttribute("Charge") Charge charge){
        chargeService.saveCharge(charge);

        return "redirect:/propertyList";
    }

    //EASEMENT
    @GetMapping("/formeasement")
    public String formeasement(Model model){
        User loggedInUser = getLoggedInUser();

        Property easement = new Easement();
        easement.setUser(loggedInUser);

        model.addAttribute("Easement", easement);
        return "formEasement";
    }

    @PostMapping("/saveeasement")
    public String saveEasement(@ModelAttribute("Easement") Easement easement){
        easementService.saveEasement(easement);

        return "redirect:/propertyList";
    }

    //LEASE
    @GetMapping("/formlease")
    public String formlease(Model model){
        User loggedInUser = getLoggedInUser();

        Property lease = new Lease();
        lease.setUser(loggedInUser);

        model.addAttribute("Lease", lease);
        return "formLease";
    }

    @PostMapping("/saveLease")
    public String saveLease(@ModelAttribute("Lease") Lease lease){
        leaseService.saveLease(lease);

        return "redirect:/propertyList";
    }

    //MAINTENANCE
    @GetMapping("/formmaintenance")
    public String formmaintenance(Model model){
        User loggedInUser = getLoggedInUser();

        Property maintenance = new Maintenance();
        maintenance.setUser(loggedInUser);

        model.addAttribute("Maintenance", maintenance);
        return "formmaintenance";
    }

    @PostMapping("/saveMaintenance")
    public String saveMaintenance(@ModelAttribute("Maintenance") Maintenance maintenance){
        maintenanceService.saveMaintenance(maintenance);

        return "redirect:/propertyList";
    }

    //MORTGAGE
    @GetMapping("/formmortgage")
    public String formmortgage(Model model){
        User loggedInUser = getLoggedInUser();

        Property mortgage = new Mortgage();
        mortgage.setUser(loggedInUser);

        model.addAttribute("Mortgage", mortgage);
        return "formMortgage";
    }

    @PostMapping("/saveMortgage")
    public String saveMortgage(@ModelAttribute("Mortgage") Mortgage mortgage){
        mortgageService.saveMortgage(mortgage);

        return "redirect:/propertyList";
    }

    //QUITRENT
    @GetMapping("/formquitrent")
    public String formquitrent(Model model){
        User loggedInUser = getLoggedInUser();

        Property quitRent = new QuitRent();
        quitRent.setUser(loggedInUser);

        model.addAttribute("QuitRent", quitRent);
        return "formQuitRent";
    }

    @PostMapping("/saveQuitRent")
    public String saveQuitRent(@ModelAttribute("QuitRent") QuitRent quitRent){
        quitRentService.saveQuitRent(quitRent);

        return "redirect:/propertyList";
    }

    //RIGHTOFWAY
    @GetMapping("/formrightofway")
    public String formrightofway(Model model){
        User loggedInUser = getLoggedInUser();

        Property rightOfWay = new RightOfWay();
        rightOfWay.setUser(loggedInUser);

        model.addAttribute("RightOfWay", rightOfWay);
        return "formRightOfWay";
    }

    @PostMapping("/saveRightOfWay")
    public String saveRightOfWay(@ModelAttribute("RightOfWay") RightOfWay rightOfWay){
        rightOfWayService.saveRightOfWay(rightOfWay);

        return "redirect:/propertyList";
    }

    //TENANCY
    @GetMapping("/formtenancy")
    public String formtenancy(Model model){
        User loggedInUser = getLoggedInUser();

        Property tenancy = new Tenancy();
        tenancy.setUser(loggedInUser);

        model.addAttribute("Tenancy", tenancy);
        return "formTenancy";
    }

    @PostMapping("/saveTenancy")
    public String saveTenancy(@ModelAttribute("Tenancy") Tenancy tenancy){
        tenancyService.saveTenancy(tenancy);

        return "redirect:/propertyList";
    }

    //TRANSFER
    @GetMapping("/formtransfer")
    public String formtransfer(Model model){
        User loggedInUser = getLoggedInUser();

        Property transfer = new Transfer();
        transfer.setUser(loggedInUser);

        model.addAttribute("Transfer", transfer);
        return "formTransfer";
    }

    @PostMapping("/savetransfer")
    public String saveTransfer(@ModelAttribute("Transfer") Transfer transfer){
        transferService.saveTransfer(transfer);

        return "redirect:/propertyList";
    }

    //UTILITIESBILL
    @GetMapping("/formutilitiesbill")
    public String formutilitiesbill(Model model){
        User loggedInUser = getLoggedInUser();

        Property utilitiesBill = new UtilitiesBill();
        utilitiesBill.setUser(loggedInUser);

        model.addAttribute("UtilitiesBill", utilitiesBill);
        return "formutilitiesbill";
    }

    @PostMapping("/saveUtilitiesBill")
    public String saveUtilitiesBill(@ModelAttribute("UtilitiesBill") UtilitiesBill utilitiesBill){
        utilitiesBillService.saveUtilitiesBill(utilitiesBill);

        return "redirect:/propertyList";
    }

    //WAQF
    @GetMapping("/formwaqf")
    public String formWaqf(Model model){
        User loggedInUser = getLoggedInUser();

        Property waqf = new Waqf();
        waqf.setUser(loggedInUser);

        model.addAttribute("Waqf", waqf);
        return "formWaqf";
    }

    @PostMapping("/saveWaqf")
    public String saveWaqf(@ModelAttribute("Waqf") Waqf waqf){
        waqfService.saveWaqf(waqf);

        return "redirect:/propertyList";
    }

    //CASH
    @GetMapping("/formcash")
    public String formcash(Model model){
        User loggedInUser = getLoggedInUser();

        Property cash = new Cash();
        cash.setUser(loggedInUser);

        model.addAttribute("Cash", cash);
        return "formcash";
    }

    @PostMapping("/saveCash")
    public String saveCash(@ModelAttribute("Cash") Cash cash){
        cashService.saveCash(cash);

        return "redirect:/propertyList";
    }

    //DEBENTURE
    @GetMapping("/formdebenture")
    public String formdebenture(Model model){
        User loggedInUser = getLoggedInUser();

        Property debenture = new Debenture();
        debenture.setUser(loggedInUser);

        model.addAttribute("Debenture", debenture);
        return "formDebenture";
    }

    @PostMapping("/saveDebenture")
    public String saveDebenture(@ModelAttribute("Debenture") Debenture debenture){
        debentureService.saveDebenture(debenture);

        return "redirect:/propertyList";
    }

    //INSURANCE
    @GetMapping("/forminsurance")
    public String forminsurance(Model model){
        User loggedInUser = getLoggedInUser();

        Property insurance = new Insurance();
        insurance.setUser(loggedInUser);

        model.addAttribute("Insurance", insurance);
        return "forminsurance";
    }

    @PostMapping("/saveInsurance")
    public String saveInsurance(@ModelAttribute("Insurance") Insurance insurance){
        insuranceService.saveInsurance(insurance);

        return "redirect:/propertyList";
    }

    //SHARE
    @GetMapping("/formshare")
    public String formshare(Model model){
        User loggedInUser = getLoggedInUser();

        Property share = new Share();
        share.setUser(loggedInUser);

        model.addAttribute("Share", share);
        return "formShare";
    }

    @PostMapping("/saveShare")
    public String saveShare(@ModelAttribute("Share") Share share){
        shareService.saveShare(share);

        return "redirect:/propertyList";
    }

    //UNITTRUST
    @GetMapping("/formunittrust")
    public String formunittrust(Model model){
        User loggedInUser = getLoggedInUser();

        Property unitTrust = new UnitTrust();
        unitTrust.setUser(loggedInUser);

        model.addAttribute("UnitTrust", unitTrust);
        return "formUnitTrust";
    }

    @PostMapping("/saveUnitTrust")
    public String saveUnitTrust(@ModelAttribute("UnitTrust") UnitTrust unitTrust){
        unitTrustService.saveUnitTrust(unitTrust);

        return "redirect:/propertyList";
    }

    //VEHICLE
    @GetMapping("/formvehicle")
    public String formvehicle(Model model){
        User loggedInUser = getLoggedInUser();

        Property vehicle = new Vehicle();
        vehicle.setUser(loggedInUser);

        model.addAttribute("Vehicle", vehicle);
        return "formVehicle";
    }

    @PostMapping("/saveVehicle")
    public String saveVehicle(@ModelAttribute("Vehicle") Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);

        return "redirect:/propertyList";
    }

}
